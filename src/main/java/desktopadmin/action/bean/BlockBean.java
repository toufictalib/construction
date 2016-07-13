package desktopadmin.action.bean;

import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;

import java.io.Serializable;
import java.util.List;

public class BlockBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6674546075344658909L;

	private List<Block> blocks;

	private List<Project> projects;

	public BlockBean()
	{
		
	}
	
	public BlockBean(List<Block> blocks, List<Project> projects)
	{
		super();
		this.blocks = blocks;
		this.projects = projects;
	}

	public List<Block> getBlocks( )
	{
		return blocks;
	}

	public void setBlocks(List<Block> blocks)
	{
		this.blocks = blocks;
	}

	public List<Project> getProjects( )
	{
		return projects;
	}

	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}

}
