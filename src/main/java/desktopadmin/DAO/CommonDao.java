package desktopadmin.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SQLQueryImpl;
import org.hibernate.transform.BasicTransformerAdapter;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import desktopadmin.model.building.Block;
import desktopadmin.model.sold.Contract;

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
	
	@SuppressWarnings({
		"unchecked", "unused"
		})
		public List<Map<String, Object>> getCustomerTransactions(Long customerId,Long contractId)
		{
			
			
			Query query = getSession().createSQLQuery(
					"CALL get_customer_transactions (:p_customer_id,:p_contract_id)")
					.setParameter("p_customer_id", customerId)
					.setParameter("p_contract_id", contractId);
					;
					
					query.setResultTransformer(new BasicTransformerAdapter()
					{
						@Override
						public Object transformTuple(Object[] tuple, String[] aliases)
						{
							Map<String, Object> map = new LinkedHashMap<>();
							for(int i=0;i<tuple.length;i++)
							{
								map.put(aliases[i], tuple[i]);
							}
							
							return map;
						}
					});
					
					
					List<Map<String, Object>> list = query.list();
			return list;
			
		}
	
	@SuppressWarnings({
		"unchecked", "unused"
		})
		public List<Map<String, Object>> getSuppliersTransactions(Long customerId,Long projectId)
		{
			
			
			Query query = getSession().createSQLQuery(
					"CALL get_supplier_transactions (:p_customer_id,:p_project_id)")
					.setParameter("p_customer_id", customerId)
					.setParameter("p_project_id", projectId);
					;
					List result = query.list();
					
					query.setResultTransformer(new BasicTransformerAdapter()
					{
						@Override
						public Object transformTuple(Object[] tuple, String[] aliases)
						{
							Map<String, Object> map = new LinkedHashMap<>();
							for(int i=0;i<tuple.length;i++)
							{
								map.put(aliases[i], tuple[i]);
							}
							
							return map;
						}
					});
					
					
					List<Map<String, Object>> list = query.list();
			return list;
			
		}
	
	@SuppressWarnings("unchecked")
	public List<Contract> getCustomerContracts(Long projectId,Long CustomerId)
	{
		String sql = "SELECT * FROM `contract` c\r\n" + 
				"LEFT JOIN real_estate re ON re.`id` = c.`real_estate`\r\n" + 
				"LEFT JOIN `block` b ON re.`block` = b.`id`\r\n" + 
				"WHERE c.`customer` = "+CustomerId+" and "
				+"b.project_id="+projectId;
		
		
		Query query = getSession()
				.createSQLQuery(sql)
				.addEntity(Contract.class);
				return query.list();
		
	}
}
