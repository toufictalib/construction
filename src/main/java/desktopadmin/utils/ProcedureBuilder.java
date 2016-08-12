package desktopadmin.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;


public class ProcedureBuilder
{
	private String name;
	private Map<String, Object> parameters;
	
	private SearchBean searchBean;
	
	public static ProcedureBuilder edit()
	{
		return new ProcedureBuilder();
	}
	
	
	
	
	public ProcedureBuilder( )
	{
		super();
		parameters = new LinkedHashMap<>();
	}




	public ProcedureBuilder setName(String name)
	{
		this.name = name;
		return this;
	}
	
	public ProcedureBuilder addParameter(String key,Object value)
	{
		parameters.put(key, value);
		return this;
	}
	
	public ProcedureBuilder addSearchBeanParameter(SearchBean searchBean)
	{
		this.searchBean = searchBean;
		
		addParameter("p_from_date", searchBean.getFromDate());
		addParameter("p_to_date", searchBean.getEndDate());
		addParameter("p_start_count", searchBean.getStartCount());
		addParameter("p_end_count", searchBean.getEndCount());
		
		return this;
	}

	public Query buildQuery(Session session)
	{
		String sql ="CALL "+name+"(";
		
		for(java.util.Map.Entry<String, Object> entry:parameters.entrySet())
		{
			sql+=":"+entry.getKey()+",";
		}
		
		if(sql.length()>0)
		{
			sql = sql.substring(0, sql.length()-1);
		}
		sql+=")";
		
		Query query = session.createSQLQuery(sql);
		System.out.println(sql);
				
		
		for(java.util.Map.Entry<String, Object> entry:parameters.entrySet())
		{
			query.setParameter(entry.getKey(), entry.getValue());
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		
		
		
		
		return query;
	}
	
	public static void main(String[] args)
	{
		ProcedureBuilder builder = ProcedureBuilder.edit();
		builder.setName("get_customer_transactions").
		addParameter("p_customer_id", 12)
		.addParameter("p_contract_id", 15);
		
		builder.addSearchBeanParameter( SearchBean.edit().setEndDate("2016-08-11 11:46:53"));
		
		builder.buildQuery(null);
	}
}
