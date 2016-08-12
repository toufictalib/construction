package report.bean;

import java.io.Serializable;

public class CustomerReportBean implements Searchable
{
	private Long customerId;

	private Long contractId;

	public CustomerReportBean(Long customerId, Long contractId)
	{
		super();
		this.customerId = customerId;
		this.contractId = contractId;
	}

	public Long getCustomerId( )
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

	public Long getContractId( )
	{
		return contractId;
	}

	public void setContractId(Long contractId)
	{
		this.contractId = contractId;
	}

	@Override
	public Serializable getHolder( )
	{
		return this;
	}

}
