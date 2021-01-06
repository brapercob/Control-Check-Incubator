
package acme.entities.roles;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.URL;

import acme.entities.RoomBooking;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Teacher extends UserRole {

	private static final long	serialVersionUID	= 1L;

	@URL
	private String				timetable;

	@URL
	private String				personalWeb;

	private String				consultingHours;

	@OneToMany
	private List<RoomBooking>	roomBookings;

}
