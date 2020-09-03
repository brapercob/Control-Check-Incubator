
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ratioOfInvestmentRoundsWithPagbad", "ratioOfApplicationsWithLink", "ratioOfApplicationsThatHavePasswordProtectedLink");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		result = new Dashboard();

		Double ratioOfInvestmentRoundsWithPagbad = this.repository.ratioOfInvestmentRoundsWithPagbad() != null ? this.repository.ratioOfInvestmentRoundsWithPagbad() : 0.;
		result.setRatioOfInvestmentRoundsWithPagbad(ratioOfInvestmentRoundsWithPagbad + "%");
		Double ratioOfApplicationsWithLink = this.repository.ratioOfApplicationsWithLink() != null ? this.repository.ratioOfApplicationsWithLink() : 0.;
		result.setRatioOfApplicationsWithLink(ratioOfApplicationsWithLink + "%");
		Double ratioOfApplicationsThatHavePasswordProtectedLink = this.repository.ratioOfApplicationsThatHavePasswordProtectedLink() != null ? this.repository.ratioOfApplicationsThatHavePasswordProtectedLink() : 0.;
		result.setRatioOfApplicationsThatHavePasswordProtectedLink(ratioOfApplicationsThatHavePasswordProtectedLink + "%");

		return result;
	}

}
