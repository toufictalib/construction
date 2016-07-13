package desktopadmin.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import desktopadmin.action.Crud;

@Component
public class Producer
{

	@Autowired
	private Crud crud;

	private static Producer instance;

	public Producer( )
	{
		System.out.println();
	}

	public static Producer get( )
	{
		if (instance == null)
		{
			try
			{
				instance = (Producer) DBStarter.getContext().getBean("producer");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return instance;
	}

	public Crud getCrud( )
	{
		return crud;
	}

}
