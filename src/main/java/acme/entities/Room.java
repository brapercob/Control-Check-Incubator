
package acme.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Teacher;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	private Integer				number;

	@NotNull
	private Integer				capacity;

	@NotNull
	private RoomType			roomType;

	@OneToMany
	private List<RoomBooking>	roomBookings;

	@OneToMany
	private List<Teacher>		stuff;

}
