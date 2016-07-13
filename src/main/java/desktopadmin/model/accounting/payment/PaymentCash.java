package desktopadmin.model.accounting.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cash")
public class PaymentCash extends Payment
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6438168626043552790L;

	
	
	
}
