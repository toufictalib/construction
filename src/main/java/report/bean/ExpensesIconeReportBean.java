package report.bean;

import java.io.Serializable;

public class ExpensesIconeReportBean implements Searchable
{


	private Long projectId;

	public ExpensesIconeReportBean( )
	{
		super();
	}

	public ExpensesIconeReportBean(Long projectId)
	{
		super();
		this.projectId = projectId;
	}


	public Long getProjectId( )
	{
		return projectId;
	}

	public void setProjectId(Long projectId)
	{
		this.projectId = projectId;
	}

	@Override
	public Serializable getHolder( )
	{
		return this;
	}

}
