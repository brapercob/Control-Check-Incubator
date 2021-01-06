
package acme.features.student.bookItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BookItem;
import acme.entities.roles.Student;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class StudentBookItemShowService implements AbstractShowService<Student, BookItem> {

	@Autowired
	private StudentBookItemRepository repository;


	@Override
	public boolean authorise(final Request<BookItem> request) {
		assert request != null;

		return true;

	}

	@Override
	public void unbind(final Request<BookItem> request, final BookItem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "barCode", "borrowed", "format", "loanPeriod", "borrower.identity.fullName", "book.title");

	}

	@Override
	public BookItem findOne(final Request<BookItem> request) {
		assert request != null;

		BookItem result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneBookItemById(id);

		return result;
	}

}
