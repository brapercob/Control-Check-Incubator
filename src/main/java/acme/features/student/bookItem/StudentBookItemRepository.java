
package acme.features.student.bookItem;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.BookItem;
import acme.entities.books.Book;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface StudentBookItemRepository extends AbstractRepository {

	@Query("select b from BookItem b where b.id = ?1")
	BookItem findOneBookItemById(int id);

	@Query("select b from Book b where b.id = ?1")
	Book findOneBookById(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select b from BookItem b where b.borrower.id = ?1")
	Collection<BookItem> findMyBookItemByUserAccountId(int id);

	@Query("select count(b) from BookItem b where b.borrower.id = ?1")
	Integer countNumberOfLoanByUserAccount(int id);

	@Query("select count(b) from BookItem b where b.book.id = ?1")
	Integer countNumberOfBookUnavailable(int id);

}
