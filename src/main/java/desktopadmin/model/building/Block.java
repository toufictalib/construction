package desktopadmin.model.building;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name="block")
public class Block extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1760521319699760870L;

	@Column(name = "name")
	private String name;

	@Column(name = "floor_nb")
	private int floorNb;

	@Column(name = "nb_flat_per_floor")
	private int nbFlatPerFloor;

	@Column(name = "flat_nb")
	private int flatNb;

	@Column(name = "store_nb")
	private int storeNb;

	@Column(name = "warehouse_nb")
	private int warehouseNb;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Flat> flats = new HashSet<>();

	public String getName( )
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getFloorNb( )
	{
		return floorNb;
	}

	public void setFloorNb(int floorNb)
	{
		this.floorNb = floorNb;
	}

	public int getNbFlatPerFloor( )
	{
		return nbFlatPerFloor;
	}

	public void setNbFlatPerFloor(int nbFlatPerFloor)
	{
		this.nbFlatPerFloor = nbFlatPerFloor;
	}

	public int getFlatNb( )
	{
		return flatNb;
	}

	public void setFlatNb(int flatNb)
	{
		this.flatNb = flatNb;
	}

	public int getStoreNb( )
	{
		return storeNb;
	}

	public void setStoreNb(int storeNb)
	{
		this.storeNb = storeNb;
	}

	public int getWarehouseNb( )
	{
		return warehouseNb;
	}

	public void setWarehouseNb(int warehouseNb)
	{
		this.warehouseNb = warehouseNb;
	}

	public Project getProject( )
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	public Set<Flat> getFlats( )
	{
		return flats;
	}

	public void setFlats(Set<Flat> flats)
	{
		this.flats = flats;
	}
	
	@Override
	public String toString( )
	{
		return name;
	}

	
	
}
