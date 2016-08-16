package desktopadmin.model.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
@DiscriminatorValue("funder")
public class Funder extends Person
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3867175200713428972L;

}
