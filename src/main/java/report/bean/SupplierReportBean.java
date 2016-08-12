package report.bean;

import java.io.Serializable;

public class SupplierReportBean implements Searchable
{
	private Long supplierId;

	private Long projectId;

	public SupplierReportBean(Long supplierId, Long projectId)
	{
		super();
		this.supplierId = supplierId;
		this.projectId = projectId;
	}

	public Long getSupplierId( )
	{
		return supplierId;
	}

	public void setSupplierId(Long supplierId)
	{
		this.supplierId = supplierId;
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
