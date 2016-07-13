package desktopadmin.model.building;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import desktopadmin.model.accounting.EnumType.Direction;


@Entity
@Table(name="person")
@DiscriminatorValue("flat")
public class Flat extends RealEstate
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 872492350631760418L;

	@Column(name="direction")
	@Enumerated(EnumType.ORDINAL)
	private Direction direction;

	public Direction getDirection( )
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	@Override
	public String toString( )
	{
	return getFloor()+ " : "+direction; 
	}
	
	
}
