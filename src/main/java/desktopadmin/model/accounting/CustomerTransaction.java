package desktopadmin.model.accounting;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.sold.Contract;

@Entity
@Table(name = "transaction")
public class CustomerTransaction extends Transaction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1922601131825377445L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract", nullable = false)
	private Contract contract;
	
	public CustomerTransaction()
	{
		this.payer = Payer.CUSTOMER;
	}

	public Contract getContract( )
	{
		return contract;
	}

	public void setContract(Contract contract)
	{
		this.contract = contract;
	}
	
	
}
