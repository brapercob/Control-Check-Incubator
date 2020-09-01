
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(ir.XXXX.id)/count(ir.id)*100.0 from InvestmentRound ir")
	Double ratioOfInvestmentRoundsWithXXXX();

	@Query("select count(a.XXXXApplication.id)/count(a.id)*100.0 from Application a")
	Double ratioOfApplicationsWithXXXX();

	@Query("select count(xa.passwordLink)/(select count(a.id) from Application a)*100.0 from XXXXApplication xa")
	Double ratioOfApplicationsThatHaveXXXX();

}
