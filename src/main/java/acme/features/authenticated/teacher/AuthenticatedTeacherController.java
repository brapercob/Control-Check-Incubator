
package acme.features.authenticated.teacher;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Teacher;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/teacher/")
public class AuthenticatedTeacherController extends AbstractController<Authenticated, Teacher> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedTeacherCreateService	createService;

	@Autowired
	private AuthenticatedTeacherUpdateService	updateService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
