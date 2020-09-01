
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

		request.unbind(entity, model, "ratioOfInvestmentRoundsWithXXXX", "ratioOfApplicationsWithXXXX", "ratioOfApplicationsThatHaveXXXX");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		result = new Dashboard();

		Double ratioOfInvestmentRoundsWithXXXX = this.repository.ratioOfInvestmentRoundsWithXXXX() != null ? this.repository.ratioOfInvestmentRoundsWithXXXX() : 0.;
		result.setRatioOfInvestmentRoundsWithXXXX(ratioOfInvestmentRoundsWithXXXX + "%");
		Double ratioOfApplicationsWithXXXX = this.repository.ratioOfApplicationsWithXXXX() != null ? this.repository.ratioOfApplicationsWithXXXX() : 0.;
		result.setRatioOfApplicationsWithXXXX(ratioOfApplicationsWithXXXX + "%");
		Double ratioOfApplicationsThatHaveXXXX = this.repository.ratioOfApplicationsThatHaveXXXX() != null ? this.repository.ratioOfApplicationsThatHaveXXXX() : 0.;
		result.setRatioOfApplicationsThatHaveXXXX(ratioOfApplicationsThatHaveXXXX + "%");

		return result;
	}

}
