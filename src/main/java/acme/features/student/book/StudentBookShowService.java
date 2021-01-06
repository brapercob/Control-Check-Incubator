
package acme.features.student.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.books.Book;
import acme.entities.roles.Student;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class StudentBookShowService implements AbstractShowService<Student, Book> {

	// Internal state -----------------------------------------------------

	@Autowired
	private StudentBookRepository repository;


	// AbstractShowService<Authenticated, Requests> interface ---------

	@Override
	public boolean authorise(final Request<Book> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Book> request, final Book entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		int bookId = entity.getId();

		model.setAttribute("bookId", bookId);

		request.unbind(entity, model, "title", "authors", "genre", "subject", "isbn", "eisbn", "language", "numberOfPages", "quantity");

	}

	@Override
	public Book findOne(final Request<Book> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Book result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
