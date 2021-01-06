
package acme.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.books.Book;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookItem extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				barCode;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	private Date				borrowed;

	private Format				format;

	@Max(30)
	@NotNull
	private Integer				loanPeriod;

	@ManyToOne
	private UserAccount			borrower;

	@ManyToOne
	private Book				book;


	@Transient
	public Date endDate() {
		Date dt = this.borrowed;
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, this.loanPeriod);
		return c.getTime();

	}
}
