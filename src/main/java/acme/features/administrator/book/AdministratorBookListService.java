
package acme.features.administrator.book;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.books.Book;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorBookListService implements AbstractListService<Administrator, Book> {

	// Internal state --------------------------------------------------------

	@Autowired
	AdministratorBookRepository repository;


	// AbstractListService<Authenticated, Requests> interface ------------

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

		request.unbind(entity, model, "title", "authors", "genre");

	}

	@Override
	public Collection<Book> findMany(final Request<Book> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Collection<Book> result;

		result = this.repository.findManyAll();

		return result;
	}

}
