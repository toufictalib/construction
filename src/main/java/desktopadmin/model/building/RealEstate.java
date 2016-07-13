package desktopadmin.model.building;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "real_estate")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
public class RealEstate extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1752826154341581229L;

	@Column(name = "description")
	protected String description;

	@Column(name = "floor")
	protected int floor;

	@Column(name = "price")
	protected double price;

	@Column(name = "area")
	protected int area;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "block", nullable = false)
	protected Block block;

	public String getDescription( )
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getFloor( )
	{
		return floor;
	}

	public void setFloor(int floor)
	{
		this.floor = floor;
	}

	public double getPrice( )
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getArea( )
	{
		return area;
	}

	public void setArea(int area)
	{
		this.area = area;
	}

	public Block getBlock( )
	{
		return block;
	}

	public void setBlock(Block block)
	{
		this.block = block;
	}
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

	    return val == null ? null : val.value();
	}

	

}
