
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Catalog extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	private Date				date;

}
