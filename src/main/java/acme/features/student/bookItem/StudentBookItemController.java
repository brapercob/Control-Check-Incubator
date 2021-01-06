
package acme.features.student.bookItem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.BookItem;
import acme.entities.roles.Student;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/student/book-item/")
public class StudentBookItemController extends AbstractController<Student, BookItem> {

	@Autowired
	private StudentBookItemListMineService	listMineService;

	@Autowired
	private StudentBookItemShowService		showService;

	@Autowired
	private StudentBookItemCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
