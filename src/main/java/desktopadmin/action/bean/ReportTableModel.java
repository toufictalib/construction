package desktopadmin.action.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import desktopadmin.model.accounting.EnumType.ExtraRowType;
import desktopadmin.utils.ConverterUtils;

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
	
	public List<List<Object>> extras;

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
	
	public static class ExtraRowIndex
	{
		public int index;
		public ExtraRowType extraRowType;
		public ExtraRowIndex(int index, ExtraRowType extraRowType)
		{
			super();
			this.index = index;
			this.extraRowType = extraRowType;
		}
		
	}

	public void addExtrass(List<ExtraRowIndex> indexes)
	{

		List<ExtraRowType> extraRowTypes = new ArrayList<>();
		for (int i = 0; i < cols.size(); i++ )
		{
			extraRowTypes.add(ExtraRowType.NONE);
		}

		for (ExtraRowIndex index : indexes)
		{
			extraRowTypes.set(index.index, index.extraRowType);
		}

		addExtras(extraRowTypes);
	}
	
	public void addExtras(List<ExtraRowType> extraRow)
	{
		if(extraRow.size()!=cols.size())
			throw new IllegalArgumentException("Extra Rows size should similar to cols size");
		
		List<Double> values = new ArrayList<>();
		for(String s:cols)
		{
			values.add(0d);
		}
		
		List<Object> lastRow = new ArrayList<>();
		for(List<Object> row:rows)
		{
			for(int i=0;i<row.size();i++)
			{
				if(extraRow.get(i)==ExtraRowType.SUM)
				{
				Double value = values.get(i);
				value+=ConverterUtils.toDouble( row.get(i));
				values.set(i, value);
				}
				else
					 values.set(i, null);
			}
		}
		
		rows.add(new ArrayList<>(values));
		
	}

	public ReportTableModel( )
	{
		super();
	}

}
