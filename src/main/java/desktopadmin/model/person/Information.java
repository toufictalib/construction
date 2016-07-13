package desktopadmin.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "information")
public class Information extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1826520596947785293L;


	@Column(name = "label")
	private String label;

	@Column(name = "value")
	private String value;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person", nullable = false)
	private Person person;
	
	public String getLabel( )
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public Person getPerson( )
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	public String getValue( )
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	

}
