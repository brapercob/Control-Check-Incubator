
package acme.entities.roles;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.entities.Subject;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends UserRole {

	private static final long	serialVersionUID	= 1L;

	@ManyToMany
	private List<Subject>		subjects;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z0-9]{6}$")
	private String				neptunCode;

}
