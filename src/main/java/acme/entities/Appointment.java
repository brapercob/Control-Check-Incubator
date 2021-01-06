
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Student;
import acme.entities.roles.Teacher;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Appointment extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	private Date				date;

	@ManyToOne(optional = false)
	private Student				student;

	@ManyToOne(optional = false)
	private Teacher				teacher;

}
