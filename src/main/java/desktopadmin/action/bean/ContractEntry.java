package desktopadmin.action.bean;

public class ContractEntry extends Entry
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 654886401197821879L;

	private Long customerId;
	public ContractEntry(Long id, String name, Long customerId)
	{
		super(id, name);
		this.customerId = customerId;
	}


	public Long getCustomerId( )
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

}
