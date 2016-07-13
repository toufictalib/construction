package desktopadmin.model.accounting.payment;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import desktopadmin.model.accounting.EnumType.PaymentType;

@Entity
@DiscriminatorValue("check")
public class PaymentCheck extends Payment
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8463801933777753602L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "check_id")
	private Check check;

	public PaymentCheck()
	{
		
	}
	
	public PaymentCheck(PaymentType paymentType)
	{
		setPaymentType(paymentType);
	}
	
	public Check getCheck( )
	{
		return check;
	}

	public void setCheck(Check check)
	{
		this.check = check;
	}
	
	
}
