package report.bean;

import java.io.Serializable;

public class StockReportBean implements Searchable
{

	private Long productId;

	private Long supplierId;

	private Long projectId;

	public StockReportBean( )
	{
		super();
	}

	public StockReportBean(Long productId, Long supplierId, Long projectId)
	{
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.projectId = projectId;
	}

	public Long getProductId( )
	{
		return productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
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
