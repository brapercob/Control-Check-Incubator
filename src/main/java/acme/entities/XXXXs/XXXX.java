
package acme.entities.XXXXs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class XXXX extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Column(length = 1000)
	@Size(min = 1, max = 1000)
	private String				description;

	@OneToOne(optional = false)
	@NotNull
	@Valid
	private InvestmentRound		investment;

}
