package desktopadmin.model.accounting.payment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Currency;
import desktopadmin.model.accounting.EnumType.PaymentType;
import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930737189046326015L;

	@Column(name = "value")
	protected double value;
	
	@Column(name = "payment_type")
	@Enumerated(EnumType.ORDINAL)
	private PaymentType paymentType = PaymentType.CASH;

	@Column(name = "currency")
	@Enumerated(EnumType.ORDINAL)
	private Currency currency = Currency.DOLLAR;
	
	@Column(name="dollar_price")
	private double dollarPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction", nullable = false)
	private Transaction transaction;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank")
	private Bank bank;

	public Bank getBank( )
	{
		return bank;
	}

	public void setBank(Bank bank)
	{
		this.bank = bank;
	}
	
	
	public double getValue( )
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public PaymentType getPaymentType( )
	{
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType)
	{
		this.paymentType = paymentType;
	}

	public Currency getCurrency( )
	{
		return currency;
	}

	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

	public double getDollarPrice( )
	{
		return dollarPrice;
	}

	public void setDollarPrice(double dollarPrice)
	{
		this.dollarPrice = dollarPrice;
	}

	public Transaction getTransaction( )
	{
		return transaction;
	}

	public void setTransaction(Transaction transaction)
	{
		this.transaction = transaction;
	}

	
	

	
}
