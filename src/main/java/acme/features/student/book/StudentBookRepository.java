
package acme.features.student.book;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.books.Book;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface StudentBookRepository extends AbstractRepository {

	@Query("select b from Book b where b.id = ?1")
	Book findOneById(int id);

	@Query("select b from Book b")
	Collection<Book> findManyAll();

}
