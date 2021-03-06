
package acme.features.authenticated.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Teacher;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuthenticatedTeacherUpdateService implements AbstractUpdateService<Authenticated, Teacher> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedTeacherRepository repository;


	@Override
	public boolean authorise(final Request<Teacher> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Teacher> request, final Teacher entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Teacher> request, final Teacher entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "personalWeb");
	}

	@Override
	public Teacher findOne(final Request<Teacher> request) {
		assert request != null;

		Teacher result;
		Principal principal;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();

		result = this.repository.findOneTeacherByUserAccountId(userAccountId);

		return result;
	}

	@Override
	public void validate(final Request<Teacher> request, final Teacher entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Teacher> request, final Teacher entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Teacher> request, final Response<Teacher> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
