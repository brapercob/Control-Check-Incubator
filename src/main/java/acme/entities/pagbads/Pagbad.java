
package acme.entities.pagbads;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pagbad extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Column(length = 1024)
	@Size(max = 1024)
	private String				description;

}
