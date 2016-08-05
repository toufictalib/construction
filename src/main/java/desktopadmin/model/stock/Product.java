package desktopadmin.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import desktopadmin.model.general.InfoEntity;

@Entity
@Table(name = "product")
public class Product extends InfoEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6927855267088532533L;

	@Column(name = "unit")
	private String unit;

	public Product( )
	{
		super();
	}

	public Product(Long id)
	{
		super(id);
	}

	public String getUnit( )
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

}
