package desktopadmin.model.accounting;

import javax.persistence.Entity;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Payer;

@Entity
@Table(name = "transaction")
public class CustomerTransaction extends Transaction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1922601131825377445L;

	public CustomerTransaction()
	{
		this.payer = Payer.CUSTOMER;
	}
}
