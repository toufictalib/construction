package desktopadmin.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import desktopadmin.model.building.Block;

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
}
