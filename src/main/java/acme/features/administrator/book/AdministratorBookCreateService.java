
package acme.features.administrator.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.books.Book;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorBookCreateService implements AbstractCreateService<Administrator, Book> {

	// Internal state -----------------------------------------------------

	@Autowired
	private AdministratorBookRepository repository;


	@Override
	public boolean authorise(final Request<Book> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Book> request, final Book entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Book> request, final Book entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "authors", "genre", "subject", "isbn", "eisbn", "language", "numberOfPages", "quantity");
	}

	@Override
	public Book instantiate(final Request<Book> request) {
		// TODO Auto-generated method stub
		Book result;

		result = new Book();

		return result;
	}

	@Override
	public void validate(final Request<Book> request, final Book entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Book> request, final Book entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
