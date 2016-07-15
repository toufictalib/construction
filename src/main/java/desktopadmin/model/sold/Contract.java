package desktopadmin.model.sold;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desktopadmin.model.building.RealEstate;
import desktopadmin.model.general.BaseEntity;
import desktopadmin.model.person.Customer;

@Entity
@Table(name = "contract")
public class Contract extends BaseEntity
{

	private static final long serialVersionUID = 7975609978966809833L;
	

	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer", nullable = false)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "real_estate", nullable = false)
	private RealEstate realEstate;
	
	@Column(name="price")
	private double price;
	
	/**
	 * Date that customer should pay all flat price
	 */
	@Column(name = "entilement_date")
	private Date entilementDate;

	@Column(name="date_update")
	private Date updateDate;

	@Column(name="date_creation")
	private Date creationDate;

	
	
	public Contract( )
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(Long id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getDescription( )
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Customer getCustomer( )
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public RealEstate getRealEstate( )
	{
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate)
	{
		this.realEstate = realEstate;
	}

	public double getPrice( )
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public Date getEntilementDate( )
	{
		return entilementDate;
	}

	public void setEntilementDate(Date entilementDate)
	{
		this.entilementDate = entilementDate;
	}

	public Date getUpdateDate( )
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public Date getCreationDate( )
	{
		return creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}
	
	
	

}
