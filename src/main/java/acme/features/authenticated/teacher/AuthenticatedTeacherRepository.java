
package acme.features.authenticated.teacher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Teacher;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTeacherRepository extends AbstractRepository {

	@Query("select t from Teacher t where t.userAccount.id = ?1")
	Teacher findOneTeacherByUserAccountId(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

}
