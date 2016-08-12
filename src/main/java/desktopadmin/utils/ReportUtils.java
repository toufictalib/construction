package desktopadmin.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.BasicTransformerAdapter;

public class ReportUtils
{

	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> toReportTableModel(Query query)
	{
		query.setResultTransformer(new BasicTransformerAdapter()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = -710254399413875754L;

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
	
	public static Query addSearchBeanElements(Query query,SearchBean searchBean)
	{
		return query.setParameter("p_start_date", searchBean.getFromDate())
				.setParameter("p_end_date", searchBean.getEndDate())
				.setParameter("p_start_count", searchBean.getStartCount())
				.setParameter("p:p_end_count", searchBean.getEndCount());
	}
}
