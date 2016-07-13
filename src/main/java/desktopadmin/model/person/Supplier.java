package desktopadmin.model.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
@DiscriminatorValue("supp")
public class Supplier extends Person
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7536698482738505473L;

	
	
}
