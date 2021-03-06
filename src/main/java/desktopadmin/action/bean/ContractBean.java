package desktopadmin.action.bean;

import java.io.Serializable;
import java.util.List;

import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.building.Block;
import desktopadmin.model.sold.Contract;

public class ContractBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Entry> customers;
	private List<Entry> suppliers;
	private List<Entry> companies;
	private List<Entry> funders;

	private List<Block> blocks;

	private Contract contract;
	
	private List<Transaction> transactions;

	private List<ContractEntry> contracts;
	
	public List<Entry> getCustomers( )
	{
		return customers;
	}

	public void setCustomers(List<Entry> customers)
	{
		this.customers = customers;
	}

	public List<Block> getBlocks( )
	{
		return blocks;
	}

	public void setBlocks(List<Block> blocks)
	{
		this.blocks = blocks;
	}

	public Contract getContract( )
	{
		return contract;
	}

	public void setContract(Contract contract)
	{
		this.contract = contract;
	}


	public List<Entry> getSuppliers( )
	{
		return suppliers;
	}

	public void setSuppliers(List<Entry> suppliers)
	{
		this.suppliers = suppliers;
	}

	public List<Entry> getCompanies( )
	{
		return companies;
	}

	public void setCompanies(List<Entry> companies)
	{
		this.companies = companies;
	}

	
	public List<Entry> getFunders( )
	{
		return funders;
	}

	public void setFunders(List<Entry> funders)
	{
		this.funders = funders;
	}

	public List<Transaction> getTransactions( )
	{
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions)
	{
		this.transactions = transactions;
	}

	public List<ContractEntry> getContracts( )
	{
		return contracts;
	}

	public void setContracts(List<ContractEntry> contracts)
	{
		this.contracts = contracts;
	}
	
	
	
	

}
