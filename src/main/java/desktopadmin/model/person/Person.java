package desktopadmin.model.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
public class Person extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7536698482738505473L;

	@Column(name = "name")
	private String name;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	@Column(name = "email")
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "title")
	private Title title;
	
	@Column(name="note")
	private String note;

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="person",cascade = CascadeType.ALL)
	private Set<Information> information;
		

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMiddleName( )
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName( )
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhone1( )
	{
		return phone1;
	}

	public void setPhone1(String phone1)
	{
		this.phone1 = phone1;
	}

	public String getPhone2( )
	{
		return phone2;
	}

	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Title getTitle( )
	{
		return title;
	}

	public void setTitle(Title title)
	{
		this.title = title;
	}

	
	public String getNote( )
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Set<Information> getInformation( )
	{
		return information;
	}

	public void setInformation(Set<Information> information)
	{
		this.information = information;
	}
	
	

}
