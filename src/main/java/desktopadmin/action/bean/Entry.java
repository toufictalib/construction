package desktopadmin.action.bean;

import java.io.Serializable;

public class Entry implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2950604716227969382L;

	private Long id;

	private String name;

	public Entry(Long id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
