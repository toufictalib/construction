package desktopadmin.model.accounting;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.general.InfoEntity;

@Entity
@Table(name = "transaction_cause")
public class TransactionCause extends InfoEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6332459029085728798L;

	/**
	 * use as identifier to get transaction cause according to payer
	 */
	@Column(name = "payer")
	@Enumerated(EnumType.ORDINAL)
	private Payer payer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentCause",cascade=CascadeType.ALL)
	private Set<Transaction> tranasactions;

	public Payer getPayer( )
	{
		return payer;
	}

	public void setPayer(Payer payer)
	{
		this.payer = payer;
	}

	public Set<Transaction> getTranasactions( )
	{
		return tranasactions;
	}

	public void setTranasactions(Set<Transaction> tranasactions)
	{
		this.tranasactions = tranasactions;
	}
	
}