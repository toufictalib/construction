package desktopadmin.model.accounting;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.accounting.EnumType.PaymentMovement;
import desktopadmin.model.accounting.payment.Payment;
import desktopadmin.model.building.Project;
import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3938371883735098904L;

	public final static double DOLLAR_CONVERTER = 1512;
	@Column(name = "description")
	private String descritpion;

	@Column(name = "reference_id")
	private long referenceId;

	@Column(name = "value", nullable = false)
	private double value;

	@Column(name = "payment_movement", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PaymentMovement paymentMovement;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Payment> payments;


	@ManyToOne
	@JoinColumn(name = "payment_cause", nullable = false)
	private TransactionCause paymentCause;

	@Column(name = "payer", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	protected Payer payer;

	@Column(name = "note")
	private String note;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project", nullable = false)
	private Project project;
	
	@Column(name="date_creation")
	private Date creationDate;

	public String getDescritpion( )
	{
		return descritpion;
	}

	public void setDescritpion(String descritpion)
	{
		this.descritpion = descritpion;
	}

	public long getReferenceId( )
	{
		return referenceId;
	}

	public void setReferenceId(long referenceId)
	{
		this.referenceId = referenceId;
	}




	public TransactionCause getPaymentCause( )
	{
		return paymentCause;
	}

	public void setPaymentCause(TransactionCause paymentCause)
	{
		this.paymentCause = paymentCause;
	}

	public Payer getPayer( )
	{
		return payer;
	}

	public void setPayer(Payer payer)
	{
		this.payer = payer;
	}

	public String getNote( )
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public double getValue( )
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public PaymentMovement getPaymentMovement( )
	{
		return paymentMovement;
	}

	public void setPaymentMovement(PaymentMovement paymentMovement)
	{
		this.paymentMovement = paymentMovement;
	}

	public Set<Payment> getPayments( )
	{
		return payments;
	}

	public void setPayments(Set<Payment> payments)
	{
		this.payments = payments;
	}

	public Date getCreationDate( )
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Project getProject( )
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}
	
	
	

}
