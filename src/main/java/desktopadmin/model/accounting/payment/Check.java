package desktopadmin.model.accounting.payment;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desktopadmin.model.accounting.Bank;
import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name="checks")
public class Check extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6510552207446832374L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank")
	private Bank bank;

	@Column(name = "check_nb")
	private Long checkId;

	@Column(name = "owner")
	private String owner;

	@Column(name = "note")
	private String note;

	@Column(name = "entilement_date")
	private Date entilementDate;

	@Column(name = "date_update")
	private Date updateDate;

	@Column(name = "creation_date")
	private Date creationDate;

	public Bank getBank( )
	{
		return bank;
	}

	public void setBank(Bank bank)
	{
		this.bank = bank;
	}

	public Long getCheckId( )
	{
		return checkId;
	}

	public void setCheckId(Long checkId)
	{
		this.checkId = checkId;
	}

	public String getOwner( )
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getNote( )
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Date getEntilementDate( )
	{
		return entilementDate;
	}

	public void setEntilementDate(Date entilementDate)
	{
		this.entilementDate = entilementDate;
	}
	
	@Override
	public String toString( )
	{
		return bank.getName() + ": " + checkId;
	}

}
