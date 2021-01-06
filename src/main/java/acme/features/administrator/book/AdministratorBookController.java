
package acme.features.administrator.book;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.books.Book;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/book/")
public class AdministratorBookController extends AbstractController<Administrator, Book> {

	// Internal state ---------------------------------------------------

	@Autowired
	private AdministratorBookListService	listService;

	@Autowired
	private AdministratorBookShowService	showService;

	@Autowired
	private AdministratorBookCreateService	createService;


	// Constructors -----------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
