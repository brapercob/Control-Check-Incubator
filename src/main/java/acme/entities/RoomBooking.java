
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Teacher;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RoomBooking extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	private Date				date;

	@ManyToOne
	private Teacher				teacher;

	@ManyToOne
	private Room				room;

}
