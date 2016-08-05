package desktopadmin.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.general.BaseEntity;

@Entity
@Table(name = "item")
public class Item extends BaseEntity
{

	private static final long serialVersionUID = -3001626481477919105L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product", nullable = false)
	private Product product;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private double quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction", nullable = false)
	private Transaction transaction;

	
	public Item( )
	{
		super();
	}

	public Item(Long id)
	{
		super(id);
	}

	public Product getProduct( )
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public double getPrice( )
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getQuantity( )
	{
		return quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public Transaction getTransaction( )
	{
		return transaction;
	}

	public void setTransaction(Transaction transaction)
	{
		this.transaction = transaction;
	}

	@Transient
	public String getUnit( )
	{
		return product!=null ? product.getUnit() : null;
	}
	
	

	
}
