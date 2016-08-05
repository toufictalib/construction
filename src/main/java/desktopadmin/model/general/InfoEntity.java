package desktopadmin.model.general;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class InfoEntity extends BaseEntity
{
	private static final long serialVersionUID = 6691376930801782716L;

	@Column(name = "name")
	protected String name;

	
	public InfoEntity( )
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public InfoEntity(Long id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString( )
	{
		return name;
	}

}
