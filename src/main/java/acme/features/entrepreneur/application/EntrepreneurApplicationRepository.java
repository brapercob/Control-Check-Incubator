
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.forums.Forum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id= ?1")
	Application findOneApplicationById(int applicationID);

	@Query("select a from Application a where a.investment.entrepreneur.id= ?1")
	Collection<Application> findApplicationsToMyInvestmentRounds(int id);

	@Query("select f from Forum f where f.investment.id = ?1")
	Forum findOneForumByInvestmentRoundId(int id);

}
