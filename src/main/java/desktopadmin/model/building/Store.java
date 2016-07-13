package desktopadmin.model.building;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sun.javafx.scene.traversal.Direction;

@Entity
@Table(name = "person")
@DiscriminatorValue("store")
public class Store extends RealEstate
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7695945829733372406L;

	@Column(name = "store_order")
	private int order;

	@Column(name = "start_counting")
	@Enumerated(EnumType.STRING)
	private Direction startCounting;

	public int getOrder( )
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}

	public Direction getStartCounting( )
	{
		return startCounting;
	}

	public void setStartCounting(Direction startCounting)
	{
		this.startCounting = startCounting;
	}
	
	
}
