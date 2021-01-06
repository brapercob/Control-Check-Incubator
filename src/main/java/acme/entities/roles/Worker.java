
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.entities.WorkerPosition;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Worker extends UserRole {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	private WorkerPosition		workerPosition;

}
