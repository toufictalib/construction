package desktopadmin.model.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name="title")
/**
 * use to add title to supplier or customer like 3askari aw Mhandes
 * @author User
 *
 */
public class Title extends BaseEntity
{
	private static final long serialVersionUID = -765715541588714863L;

	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "title",cascade=CascadeType.ALL)
	private Set<Person> persons;

	
	public Title( )
	{
		super();
	}

	public Title(String name)
	{
		super();
		this.name = name;
	}

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Person> getPersons( )
	{
		return persons;
	}

	public void setPersons(Set<Person> persons)
	{
		this.persons = persons;
	}
	
	@Override
	public String toString( )
	{
		return name;
	}
	
	
}
