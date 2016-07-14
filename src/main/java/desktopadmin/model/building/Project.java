package desktopadmin.model.building;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "project")
public class Project extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6901719528697343918L;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Block> blocks;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Transaction> transactions;

	 @OneToOne(mappedBy = "project",cascade=CascadeType.ALL)
	private Address address;

	@Column(name = "flat_price_by_meter")
	private double flatPriceByMeter;

	@Column(name = "store_price_by_meter")
	private double storePriceByMeter;

	@Column(name = "warehouse_price_by_meter")
	private double warehousePriceByMeter;

	@Column(name = "date_start")
	private Date startDate;

	@Column(name = "date_due")
	private Date dueDate;

	@Column(name = "date_update")
	private Date updateDate;

	@Column(name = "date_creation")
	private Date creationDate;

	
	public Project( )
	{
		super();
	}

	public Project(Long id)
	{
		super(id);
	}

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Block> getBlocks( )
	{
		return blocks;
	}

	public void setBlocks(Set<Block> blocks)
	{
		this.blocks = blocks;
	}

	public Address getAddress( )
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public double getFlatPriceByMeter( )
	{
		return flatPriceByMeter;
	}

	public void setFlatPriceByMeter(double flatPriceByMeter)
	{
		this.flatPriceByMeter = flatPriceByMeter;
	}

	public double getStorePriceByMeter( )
	{
		return storePriceByMeter;
	}

	public void setStorePriceByMeter(double storePriceByMeter)
	{
		this.storePriceByMeter = storePriceByMeter;
	}

	public double getWarehousePriceByMeter( )
	{
		return warehousePriceByMeter;
	}

	public void setWarehousePriceByMeter(double warehousePriceByMeter)
	{
		this.warehousePriceByMeter = warehousePriceByMeter;
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

	public Set<Transaction> getTransactions( )
	{
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions)
	{
		this.transactions = transactions;
	}

	public Date getStartDate( )
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getDueDate( )
	{
		return dueDate;
	}

	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	@Override
	public String toString( )
	{
		return name;
	}

}
