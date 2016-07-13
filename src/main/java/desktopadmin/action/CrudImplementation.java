package desktopadmin.action;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desktopadmin.DAO.CommonDao;
import desktopadmin.action.bean.BlockBean;
import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.Entry;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;
import desktopadmin.model.person.Company;
import desktopadmin.model.person.Customer;
import desktopadmin.model.person.Supplier;

@Service
@Transactional
public class CrudImplementation extends UnicastRemoteObject implements Crud
{
	private static final long serialVersionUID = -6303807045680035026L;
	

	public CrudImplementation() throws RemoteException
	{
		super(25487);
	}

	@Autowired
	CommonDao commonDao;

	@Override
	public <T> List<T> list(Class<T> clazz)throws RemoteException
	{
		return commonDao.list(clazz);
	}

	@Override
	public <T> void saveOrUpdate(Collection<T> data)throws RemoteException
	{
		for (T t : data)
		{
			commonDao.saveOrUpdate(t);
		}

	}

	@Override
	public <T> void delete(Collection<T> data)throws RemoteException
	{
		commonDao.deleteMass(data);
		
	}

	@Override
	public String getName( ) throws RemoteException
	{
		return "Toufic";
	}

	@Override
	public BlockBean getBlockBean( ) throws RemoteException
	{
		List<Project> projects = list(Project.class);
		List<Block> blocks = list(Block.class);
		return new BlockBean(blocks, projects);
	}

	@Override
	public ContractBean getContractBean(Long projectId) throws RemoteException
	{
		List<Block> blocksByProject = commonDao.getBlocksByProject(projectId);
		
		//init flats
		for(Block block:blocksByProject)
		{
			Hibernate.initialize(block.getFlats());
		}
		
		List<Customer> customers = list(Customer.class);
		List<Entry> customerEntries = customers.stream().map(e->new Entry(e.getId(),e.getName())).collect(Collectors.toList());
		
		ContractBean contractBean = new ContractBean();
		contractBean.setBlocks(blocksByProject);
		contractBean.setCustomers(customerEntries);
		
		return contractBean;
	}
	
	@Override
	public ContractBean getSupplierContractBean(Long projectId) throws RemoteException
	{
		List<Block> blocksByProject = commonDao.getBlocksByProject(projectId);
		
		//init flats
		for(Block block:blocksByProject)
		{
			Hibernate.initialize(block.getFlats());
		}
		
		List<Supplier> suppliers = list(Supplier.class);
		List<Entry> supplierEntries = suppliers.stream().map(e->new Entry(e.getId(),e.getName())).collect(Collectors.toList());

		List<Company> companies= list(Company.class);
		List<Entry> companiesEntries = companies.stream().map(e->new Entry(e.getId(),e.getName())).collect(Collectors.toList());
		
		ContractBean contractBean = new ContractBean();
		contractBean.setBlocks(blocksByProject);
		contractBean.setCompanies(companiesEntries);
		contractBean.setSuppliers(supplierEntries);
		
		return contractBean;
	}
	

	@Override
	public void saveContract(ContractBean contractBean) throws RemoteException
	{
		commonDao.save(contractBean.getContract());
		commonDao.saveMass(contractBean.getTransactions());
		
	}

}
