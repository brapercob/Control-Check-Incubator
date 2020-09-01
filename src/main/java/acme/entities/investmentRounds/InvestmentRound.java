
package acme.entities.investmentRounds;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.URL;

import acme.entities.XXXXs.XXXX;
import acme.entities.activities.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	private static final long			serialVersionUID	= 1L;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$")
	private String						ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date						creationDate;

	@NotBlank
	@Pattern(regexp = "^(SEED|ANGEL|SERIES-A|SERIES-B|SERIES-C|BRIDGE)$")
	private String						kindOfRound;

	@NotBlank
	@Size(min = 1, max = 255)
	private String						title;

	@NotBlank
	@Size(min = 1, max = 255)
	private String						description;

	@NotNull
	@Valid
	private Money						amount;

	@URL
	@Size(max = 255)
	private String						optionalLink;

	@OneToMany(mappedBy = "investment")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<@Valid Activity>	workProgramme;

	@ManyToOne(optional = false)
	@Valid
	private Entrepreneur				entrepreneur;

	@OneToOne(optional = true)
	@Valid
	private XXXX						XXXX;


	@Transient
	public boolean sumActivitiesBudgets() {
		Boolean result = false;

		if (this.workProgramme.size() != 0) {
			Double sum = 0.;
			for (Activity act : this.workProgramme) {
				sum += act.getBudget().getAmount();
			}

			if (sum.equals(this.amount.getAmount())) {
				result = true;
			}
		}

		return result;
	}

}
