
package acme.entities.pagbadApplications;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PagbadApplication extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Size(max = 255)
	private String				pagbadOffer;

	@Size(max = 255)
	@URL
	private String				pagbadOfferLink;

	@Size(max = 255)
	private String				passwordLink;

}
