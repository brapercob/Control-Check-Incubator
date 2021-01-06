
package acme.entities.books;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotBlank
	@Size(min = 1, max = 255)
	private String				authors;

	@NotBlank
	private String				genre;

	@NotBlank
	private String				subject;

	@NotBlank
	@Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
	private String				isbn;

	private String				eisbn;

	@NotBlank
	private String				language;

	@NotNull
	private Integer				numberOfPages;

	@NotNull
	private Integer				quantity;

}
