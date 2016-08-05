package desktopadmin.utils;

public class ConverterUtils
{
	public static double toDouble(Object o)
	{
		double v = 0;
		
		try
		{
		Double k =toDoubleWithException(o);
		v=k==null ? 0 : k;
		}
		catch(NumberFormatException e)
		{
			
		}
		
		
		return v;
	}
	
	public static Double toDoubleWithException(Object o) throws NumberFormatException
	{
		if (o != null) return Double.parseDouble(o.toString());
		return null;
	}
	
	/**
	 * 
	 * @param o
	 * @return null in case of exception
	 */
	public static Double toDoubleWithOutException(Object o) 
	{
		if (o != null) 
		{
			try
			{
				return Double.parseDouble(o.toString());
			}
			catch(NumberFormatException e)
			{
				return null;
			}
		}
		return null;
	}
}
