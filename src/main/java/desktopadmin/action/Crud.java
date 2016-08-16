package desktopadmin.action;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

import desktopadmin.action.bean.BlockBean;
import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.model.sold.Contract;
import desktopadmin.utils.SearchBean;

public interface Crud extends Remote
{
	<T> List<T> list(Class<T> clazz)throws RemoteException;
	
	<T> void delete(Collection<T> data)throws RemoteException;
	
	<T> void saveOrUpdate(Collection<T> data)throws RemoteException;
	
	String getName()throws RemoteException;
	
	BlockBean  getBlockBean() throws RemoteException;
	
	ContractBean getContractBean(Long projectId) throws RemoteException;
	
	void saveContract(ContractBean contractBean) throws RemoteException;

	ContractBean getSupplierContractBean(Long projectId) throws RemoteException;


	ReportTableModel getCustomerTransaction(SearchBean searchBean)  throws RemoteException;

	ReportTableModel getSupplierTransaction(SearchBean searchBean) throws RemoteException;

	List<Contract> getCustomerContracts(SearchBean searchBean) throws RemoteException;

	List<Contract> getCustomerContracts(Long projectId) throws RemoteException;

	ReportTableModel getProjectExpensesIncome(SearchBean searchBean) throws RemoteException;

	ReportTableModel getStock(SearchBean searchBean) throws RemoteException;

	ReportTableModel getFundersTransaction(SearchBean searchBean)throws RemoteException;
	
}
