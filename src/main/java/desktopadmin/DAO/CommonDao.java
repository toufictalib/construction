package desktopadmin.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.accounting.Transaction;
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
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getCustomerTransactions(Long customerId,Long projectId)
	{
		Criteria c = getSession().createCriteria(Transaction.class);
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		c.add(Restrictions.eq("",Payer.SUPPLIER));
		return c.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Contract> getCustomerContracts(Long projectId)
	{
		String sql = "SELECT * FROM `contract` c\r\n" + 
				"LEFT JOIN real_estate re ON re.`id` = c.`real_estate`\r\n" + 
				"LEFT JOIN `block` b ON re.`block` = b.`id`\r\n" + 
				"WHERE b.`project_id` = "+projectId;
		
		Query query = getSession()
				.createSQLQuery(sql)
				.addEntity(Contract.class);
				return query.list();
		
	}
	
}
