
package acme.features.student.bookItem;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BookItem;
import acme.entities.roles.Student;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class StudentBookItemListMineService implements AbstractListService<Student, BookItem> {

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

		request.unbind(entity, model, "book.title", "borrowed", "loanPeriod");

	}

	@Override
	public Collection<BookItem> findMany(final Request<BookItem> request) {
		assert request != null;

		Collection<BookItem> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findMyBookItemByUserAccountId(principal.getAccountId());

		return result;
	}

}
