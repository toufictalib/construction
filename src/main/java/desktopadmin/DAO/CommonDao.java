package desktopadmin.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import report.bean.CustomerContractReportBean;
import report.bean.CustomerReportBean;
import report.bean.ExpensesIconeReportBean;
import report.bean.StockReportBean;
import report.bean.SupplierReportBean;
import desktopadmin.model.building.Block;
import desktopadmin.model.sold.Contract;
import desktopadmin.utils.ProcedureBuilder;
import desktopadmin.utils.ReportUtils;
import desktopadmin.utils.SearchBean;

@Repository
public class CommonDao extends EmptyDAO
{


	@SuppressWarnings("unchecked")
	public List<Block> getBlocksByProject(Long projectId)
	{
		Criteria criteria = getSession().createCriteria(Block.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		
		return criteria.list();
		
	}
	
	/*@SuppressWarnings("unchecked")
	public List<Transaction> getCustomerTransactions(Long customerId,Long projectId)
	{
		Criteria c = getSession().createCriteria(Transaction.class);
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		return c.list();
		
	}*/
	
	@SuppressWarnings("unchecked")
	public List<Contract> getCustomerContracts(Long projectId)
	{
		String sql = "SELECT * FROM `contract` c\r\n" + 
				"LEFT JOIN real_estate re ON re.`id` = c.`real_estate`\r\n" + 
				"LEFT JOIN `block` b ON re.`block` = b.`id`\r\n" + 
				"WHERE b.project_id=  "+projectId;
		
		Query query = getSession()
				.createSQLQuery(sql)
				.addEntity(Contract.class);
				return query.list();
		
	}
	
		public List<Map<String, Object>> getCustomerTransactions(SearchBean searchBean)
		{
			
			
			CustomerReportBean customerBean = (CustomerReportBean) searchBean.getHolder();
			
			Query query = ProcedureBuilder.edit().setName("get_customer_transactions")
			.addParameter("p_customer_id", customerBean.getCustomerId())
			.addParameter("p_contract_id", customerBean.getContractId())
			.addSearchBeanParameter(searchBean)
			.buildQuery(getSession());
			
		/*	Query query = getSession().createSQLQuery(
					"CALL get_customer_transactions (:p_customer_id,:p_contract_id,"
					+ ":p_from_date,:p_to_date,:p_start_count,:p_end_count)")
					.setParameter("p_customer_id", customerBean.getCustomerId())
					.setParameter("p_contract_id", customerBean.getContractId())
					;
			query = ReportUtils.addSearchBeanElements(query, searchBean);*/
					
					List<Map<String, Object>> list = ReportUtils.toReportTableModel(query);
					return list;
			
		}
	
		public List<Map<String, Object>> getSuppliersTransactions(SearchBean searchBean)
		{
			
			SupplierReportBean bean = (SupplierReportBean) searchBean.getHolder();
			Query query = ProcedureBuilder.edit().setName("get_supplier_transactions")
					.addParameter("p_supplier_id", bean.getSupplierId())
					.addParameter("p_project_id", bean.getProjectId())
					.addSearchBeanParameter(searchBean)
					.buildQuery(getSession());
			
		/*	Query query = getSession().createSQLQuery(
					"CALL get_supplier_transactions (:p_supplier_id,:p_project_id,"
					+ ":p_from_date,:p_to_date,:p_start_count,:p_end_count)")
					.setParameter("p_supplier_id", bean.getSupplierId())
					.setParameter("p_project_id", bean.getProjectId())
					;
			query = ReportUtils.addSearchBeanElements(query, searchBean);*/
					
					List<Map<String, Object>> list = ReportUtils.toReportTableModel(query);
					return list;
			
		}
	
	@SuppressWarnings("unchecked")
	public List<Contract> getCustomerContracts(SearchBean searchBean)
	{
		
		CustomerContractReportBean bean = (CustomerContractReportBean) searchBean.getHolder();
		String sql = "SELECT * FROM `contract` c\r\n" + 
				"LEFT JOIN real_estate re ON re.`id` = c.`real_estate`\r\n" + 
				"LEFT JOIN `block` b ON re.`block` = b.`id`\r\n" + 
				"WHERE c.`customer` = "+bean.getCustomerId()+" and "
				+"b.project_id="+bean.getProjectId();
		
		
		Query query = getSession()
				.createSQLQuery(sql)
				.addEntity(Contract.class);
				return query.list();
		
	}
	
		public List<Map<String, Object>> getProjectExpensesIncome(SearchBean searchBean)
		{
			
			ExpensesIconeReportBean bean = (ExpensesIconeReportBean) searchBean.getHolder();
			
			Query query = ProcedureBuilder.edit().setName("get_project_expenses_incomes")
					.addParameter("p_project_id", bean.getProjectId())
					.addSearchBeanParameter(searchBean)
					.buildQuery(getSession());
			
			/*Query query = getSession().createSQLQuery(
					"CALL get_project_expenses_incomes (:p_project_id,:p_start_date,:p_end_date,:p_start_count,:p:p_end_count)")
					.setParameter("p_project_id", bean.getProjectId())
					
					;
			
			query = ReportUtils.addSearchBeanElements(query, searchBean);*/
					
					List<Map<String, Object>> list = ReportUtils.toReportTableModel(query);
			return list;
			
		}
		
		public List<Map<String, Object>> getStock(SearchBean searchBean)
		{
			StockReportBean bean = (StockReportBean) searchBean.getHolder();
			
			Query query = ProcedureBuilder.edit().setName("get_stock")
					.addParameter("p_product_id", bean.getProductId())
					.addParameter("p_supplier_id", bean.getSupplierId())
					.addParameter("p_project_id", bean.getProjectId())
					.addSearchBeanParameter(searchBean)
					.buildQuery(getSession());
			
			/*Query query = getSession().createSQLQuery(
					"CALL get_stock (:p_product_id,:p_supplier_id,:p_project_id,"
					+ ":p_from_date,:p_to_date,:p_start_count,:p_end_count)")
					.setParameter("p_product_id", bean.getProductId())
					.setParameter("p_supplier_id", bean.getSupplierId())
					.setParameter("p_project_id", bean.getProjectId())
					;
			
					query = ReportUtils.addSearchBeanElements(query, searchBean);*/
					
					List<Map<String, Object>> list = ReportUtils.toReportTableModel(query);
			return list;
			
		}

	
	
}
