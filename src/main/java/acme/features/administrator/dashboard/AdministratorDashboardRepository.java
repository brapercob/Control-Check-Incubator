
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(ir.pagbad.id)/count(ir.id)*100.0 from InvestmentRound ir")
	Double ratioOfInvestmentRoundsWithPagbad();

	@Query("select count(a.pagbadApplication.pagbadOfferLink)/count(a.id)*100.0 from Application a")
	Double ratioOfApplicationsWithLink();

	@Query("select count(pa.passwordLink)/(select count(a.id) from Application a)*100.0 from PagbadApplication pa")
	Double ratioOfApplicationsThatHavePasswordProtectedLink();

}
