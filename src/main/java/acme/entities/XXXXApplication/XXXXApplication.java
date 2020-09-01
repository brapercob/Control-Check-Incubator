
package acme.entities.XXXXApplication;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class XXXXApplication extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Size(max = 255)
	private String				XXXXOffer;

	@Size(max = 255)
	@URL
	private String				XXXXOfferLink;

	@Size(max = 255)
	private String				passwordLink;

}
