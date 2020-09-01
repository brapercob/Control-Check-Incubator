
package acme.features.entrepreneur.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurApplicationShowService implements AbstractShowService<Entrepreneur, Application> {

	@Autowired
	private EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int applicationID;
		Application application;
		Entrepreneur entrepreneur;
		Principal principal;

		applicationID = request.getModel().getInteger("id");
		application = this.repository.findOneApplicationById(applicationID);
		entrepreneur = application.getInvestment().getEntrepreneur();
		principal = request.getPrincipal();

		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//Aux tiene offer
		boolean haveXXXXApplication;

		haveXXXXApplication = entity.getXXXXApplication() != null;
		model.setAttribute("haveXXXXApplication", haveXXXXApplication);

		//Unbind con offer
		if (haveXXXXApplication) {
			request.unbind(entity, model, "ticker", "creationDate", "statement", "investmentOffer", "status", "rejectReason", "investment.ticker", "XXXXApplication.XXXXOffer", "XXXXApplication.XXXXOfferLink", "XXXXApplication.passwordLink");
			//Unbind sin offer
		} else {
			request.unbind(entity, model, "ticker", "creationDate", "statement", "investmentOffer", "status", "rejectReason", "investment.ticker");
		}
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int applicationID;

		applicationID = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(applicationID);

		return result;
	}

}
