
package acme.entities.roles;

import javax.persistence.Entity;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Visitor extends UserRole {

	private static final long serialVersionUID = 1L;

}
