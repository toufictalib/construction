package report.bean;

import java.io.Serializable;

public class CustomerContractReportBean implements Searchable
{
	private Long customerId;

	private Long projectId;

	public CustomerContractReportBean(Long customerId, Long contractId)
	{
		super();
		this.customerId = customerId;
		this.projectId = contractId;
	}

	public Long getCustomerId( )
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

	public Long getProjectId( )
	{
		return projectId;
	}

	public void setProjectId(Long contractId)
	{
		this.projectId = contractId;
	}

	@Override
	public Serializable getHolder( )
	{
		return this;
	}

}
