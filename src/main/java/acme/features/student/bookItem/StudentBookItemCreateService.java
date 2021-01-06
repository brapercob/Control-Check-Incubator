
package acme.features.student.bookItem;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BookItem;
import acme.entities.books.Book;
import acme.entities.roles.Student;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class StudentBookItemCreateService implements AbstractCreateService<Student, BookItem> {

	@Autowired
	StudentBookItemRepository repository;


	@Override
	public boolean authorise(final Request<BookItem> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<BookItem> request, final BookItem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "borrowed", "borrower", "book");

	}

	@Override
	public void unbind(final Request<BookItem> request, final BookItem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "barCode", "format", "loanPeriod");

		model.setAttribute("bookId", request.getModel().getAttribute("bookId"));
	}

	@Override
	public BookItem instantiate(final Request<BookItem> request) {
		assert request != null;

		BookItem result;
		int currentUserId;
		UserAccount currentUserAccount;
		int bookId;
		Book book;

		currentUserId = request.getPrincipal().getAccountId();
		bookId = request.getModel().getInteger("bookId");

		currentUserAccount = this.repository.findOneUserAccountById(currentUserId);
		book = this.repository.findOneBookById(bookId);
		Date moment = new Date(System.currentTimeMillis() - 1);
		result = new BookItem();

		result.setBorrower(currentUserAccount);
		result.setBook(book);
		result.setBorrowed(moment);

		return result;
	}

	@Override
	public void validate(final Request<BookItem> request, final BookItem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//Validate that the number of loans of the user is less than 10 (Example)
		boolean loansAvailable = true;
		int currentUserId;
		currentUserId = request.getPrincipal().getAccountId();
		Integer numberLoan = this.repository.countNumberOfLoanByUserAccount(currentUserId);
		loansAvailable = numberLoan < 3;
		if (!loansAvailable) {
			errors.state(request, false, "loanPeriod", "student.book-item.error.no-loan-left");
		}
		//Validate that are books left in the library for loan
		boolean booksAvailable = true;
		int bookId;
		bookId = request.getModel().getInteger("bookId");
		Book book;
		Integer numberOfBookInLoan = this.repository.countNumberOfBookUnavailable(bookId);
		book = this.repository.findOneBookById(bookId);
		Double booksLeft = (double) (book.getQuantity() - numberOfBookInLoan);
		booksAvailable = booksLeft > 0;
		if (!booksAvailable) {
			errors.state(request, false, "loanPeriod", "student.book-item.error.no-books-left");
		}
	}

	@Override
	public void create(final Request<BookItem> request, final BookItem entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);

		entity.setBorrowed(moment);

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<BookItem> request, final Response<BookItem> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}
}
