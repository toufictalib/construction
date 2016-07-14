package desktopadmin.model.building;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name="address")
public class Address extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3174501035457777687L;

	public enum County
	{
		AYROUNIEH, BADAWI;
	}

	public enum Caza
	{
		MINIEH_DANIEH, TRIPOLI, ZGHARTA
	}

	@Column(name = "description")
	private String description;

	@Column(name = "county")
	@Enumerated(EnumType.ORDINAL)
	private County county;

	@Column(name = "caza")
	@Enumerated(EnumType.ORDINAL)
	private Caza caza;

	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "project_id")
	private Project project;
	
	public Address( )
	{
		super();
	}

	public Address(String description, County county, Caza caza)
	{
		super();
		this.description = description;
		this.county = county;
		this.caza = caza;
	}

	public String getDescription( )
	{
		return description;
	}

	public void setDescription(String descritpion)
	{
		this.description = descritpion;
	}

	public County getCounty( )
	{
		return county;
	}

	public void setCounty(County county)
	{
		this.county = county;
	}

	public Caza getCaza( )
	{
		return caza;
	}

	public void setCaza(Caza caza)
	{
		this.caza = caza;
	}

	
	public Project getProject( )
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	@Override
	public String toString( )
	{
		return "Address : "+ description + ", county=" + county + ", caza=" + caza;
	}
	
	

}
