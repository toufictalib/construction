package desktopadmin.action.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ReportTableModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204495068283730057L;

	public List<String> cols;

	@SuppressWarnings("rawtypes")
	public List<Class> clazzes;

	public List<List<Object>> rows;

	public static ReportTableModel create(List<Map<String, Object>> list)
	{
		ReportTableModel model = new ReportTableModel();

		model.cols = new ArrayList<>();
		model.rows = new ArrayList<>();
		
		boolean columnFilled = false;
		for (Map<String, Object> map: list)
		{
			List<Object> row = new ArrayList<>();
			model.rows.add(row);
			for(java.util.Map.Entry<String, Object> entry:map.entrySet())
			{
				if(!columnFilled)
				{
					model.cols.add(entry.getKey());
				}
				row.add(entry.getValue());
				
			}
			
			if(model.rows.size()==1)
			{
				columnFilled = true;
			}

		}
		
		model.clazzes = new ArrayList<>(Collections.nCopies(model.cols.size(), Object.class));

		return model;

	}

	public ReportTableModel( )
	{
		super();
	}

}
