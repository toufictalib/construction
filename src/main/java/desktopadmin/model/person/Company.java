package desktopadmin.model.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
@DiscriminatorValue("co")
public class Company extends Person
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 235205314811558711L;

}
