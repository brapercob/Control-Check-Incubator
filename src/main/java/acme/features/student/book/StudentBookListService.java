
package acme.features.student.book;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.books.Book;
import acme.entities.roles.Student;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class StudentBookListService implements AbstractListService<Student, Book> {

	// Internal state --------------------------------------------------------

	@Autowired
	StudentBookRepository repository;


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
