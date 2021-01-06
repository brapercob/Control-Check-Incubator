
package acme.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import acme.entities.roles.Student;
import acme.entities.roles.Teacher;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Subject extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	private String				name;

	private Double				grade;

	//Relationships
	@ManyToOne(optional = false)
	private Teacher				teacher;

	@ManyToMany
	private List<Student>		students;

}
