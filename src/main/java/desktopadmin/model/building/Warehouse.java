package desktopadmin.model.building;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
@DiscriminatorValue("warehouse")
public class Warehouse extends RealEstate
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2590647685527602880L;

}
