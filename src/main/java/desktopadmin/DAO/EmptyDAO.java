package desktopadmin.DAO;

import java.util.Collection;
import java.util.List;

import javassist.NotFoundException;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class EmptyDAO
{
	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession( )
	{
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> excecuteQuery(String sql, Class<T> clazz)
	{
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(clazz);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	protected <T> T excecuteQueryForUniqueResult(String sql, Class<T> clazz)
	{
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(clazz);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(Class<T> clazz)
	{
		{
			String hql = "FROM " + clazz.getSimpleName();
			Query query = getSession().createQuery(hql);
			return query.list();
		}
	}

	public void saveOrUpdate(Object t)
	{
		getSession().saveOrUpdate(t);
	}

	public void save(Object t)
	{
		getSession().save(t);
	}

	public void saveMass(List<?> list)
	{
		for (int i = 0; i < list.size(); i++ )
		{
			save(list.get(i));
			if (i % 100 == 0)
			{
				getSession().flush();
				getSession().clear();
			}
		}
	}

	public void delete(Object t)
	{
		getSession().delete(t);
	}

	public void deleteMass(Collection<?> list)
	{
		for (Object o : list)
			delete(o);
	}

	public void update(Object t)
	{
		getSession().saveOrUpdate(t);
	}
	
	public void merge(Object t)
	{
		getSession().merge(t);
	}

	public void updateMass(List<?> list) throws NotFoundException
	{
		for (int i = 0; i < list.size(); i++ )
		{
			update(list.get(i));
			if (i % 100 == 0)
			{
				getSession().flush();
				getSession().clear();
			}
		}
	}

	@SuppressWarnings({"unchecked"})
	public <T> T getValueById(Class<T> type, int id)
	{
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings({"unchecked"})
	public <T> T getValueById(Class<T> type, long id)
	{
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings({"unchecked"})
	public <T> T getValueForUpdateById(Class<T> type, int id)
	{
		return (T) getSession().get(type, id, new LockOptions(LockMode.PESSIMISTIC_WRITE));
	}

	@SuppressWarnings({"unchecked"})
	public <T> T getValueForUpdateById(Class<T> type, long id)
	{
		return (T) getSession().get(type, id, new LockOptions(LockMode.PESSIMISTIC_WRITE));
	}
}
