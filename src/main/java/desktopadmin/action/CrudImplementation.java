package desktopadmin.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desktopadmin.DAO.CommonDao;
import desktopadmin.action.bean.BlockBean;
import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.ContractEntry;
import desktopadmin.action.bean.Entry;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;
import desktopadmin.model.general.BaseEntity;
import desktopadmin.model.person.Company;
import desktopadmin.model.person.Customer;
import desktopadmin.model.person.Supplier;
import desktopadmin.model.sold.Contract;

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
		if(data.isEmpty())
		{
			return;
		}
		
		//get Clazz
		Class<T> clazz = getClazz(data);
		
		
		for (T t : data)
		{
			commonDao.saveOrUpdate(t);
		}
		
		
		Set<T> incommingValues  = new HashSet<>(data);
		
		for(T t:list(clazz))
		{
			if(incommingValues.contains(t))
				continue;
			
			T instance;
			try
			{
				BaseEntity baseEntity = (BaseEntity) t;
				instance = clazz.newInstance();
				Method findDeclaredMethod = BeanUtils.findDeclaredMethod(clazz, "setId", Long.class);
				findDeclaredMethod.invoke(instance, baseEntity.getId());
				
				
				commonDao.getSession().evict(t);
				commonDao.delete(instance);
			}
			catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				throw new RemoteException(e.getMessage());
				
			}
			
		}
		
		

	}

	@SuppressWarnings("unchecked")
	private <T> Class<T> getClazz(Collection<T> data)
	{
		Iterator<T> iterator = data.iterator();
		Class<T> clazz = null;
		while(iterator.hasNext())
		{
			clazz = (Class<T>) iterator.next().getClass();
			break;
		}
		return clazz;
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
		List<Contract> contracts = commonDao.getCustomerContracts(projectId);
		
		List<Entry> customerEntries = customers.stream().map(e->new Entry(e.getId(),e.getName())).collect(Collectors.toList());
		List<ContractEntry> contractEntries = contracts.stream().map(e->new ContractEntry(e.getId(),e.getDescription(),e.getCustomer().getId())).collect(Collectors.toList());

		ContractBean contractBean = new ContractBean();
		contractBean.setBlocks(blocksByProject);
		contractBean.setCustomers(customerEntries);
		contractBean.setContracts(contractEntries);
		
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
