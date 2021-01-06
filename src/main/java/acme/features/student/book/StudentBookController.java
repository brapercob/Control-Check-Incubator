
package acme.features.student.book;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.books.Book;
import acme.entities.roles.Student;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("student/book/")
public class StudentBookController extends AbstractController<Student, Book> {

	// Internal state ---------------------------------------------------

	@Autowired
	private StudentBookListService	listService;

	@Autowired
	private StudentBookShowService	showService;


	// Constructors -----------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
