package desktopadmin.DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

public abstract class GeneralDAO<T> extends EmptyDAO
{
	protected Class<T> type;

	public GeneralDAO( )
	{
		findClassType();
	}

	@SuppressWarnings({
	"rawtypes", "unchecked"
	})
	private void findClassType( )
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T getValueById(int id)
	{
		return super.getValueById(type, id);
	}

	public T getValueById(long id)
	{
		return super.getValueById(type, id);
	}

	public T getValueForUpdateById(int id)
	{
		return super.getValueForUpdateById(type, id);
	}

	public T getValueForUpdateById(long id)
	{
		return super.getValueForUpdateById(type, id);
	}

	public List<T> list( )
	{
		return super.list(type);
	}

	public static <T> List<T> listAndCast(Criteria q)
	{
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) q.list();
		return list;
	}

	public static <T> List<T> listAndCast(Query q)
	{
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) q.list();
		return list;
	}
}
