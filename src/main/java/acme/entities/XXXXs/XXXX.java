
package acme.entities.XXXXs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class XXXX extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Column(length = 1000)
	@Size(max = 1000)
	private String				description;

}
