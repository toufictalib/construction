package desktopadmin.context;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import desktopadmin.model.building.Address;
import desktopadmin.model.building.Address.Caza;
import desktopadmin.model.building.Address.County;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;

public class DBStarter
{
	public static ClassPathXmlApplicationContext context = null;

	public void init( )
	{
		try
		{
			
			context = new ClassPathXmlApplicationContext("general/BeanLocations.xml");
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
			if (context != null)
			{
				context.stop();
			}
		}
	}


	public static ClassPathXmlApplicationContext getContext( )
	{
		return context;
	}

	public static void main(String[] args)
	{
		//DBStarter dbStarter= new DBStarter();
		//dbStarter.init();
		//Producer producer = (Producer) DBStarter.getContext().getBean("producer");
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/config/server-context.xml");
		// System.out.println("Waiting for requests"); 
DBStarter dbStarter = new DBStarter();
dbStarter.init();
		if(true)
			return;
		Address address = new Address("Al tarik l3am jenib supermarket al alam", County.BADAWI, Caza.ZGHARTA);
		Block block = new Block();
		block.setFlatNb(5);
		block.setFloorNb(5);
		block.setName("A");
		block.setNbFlatPerFloor(3);
		block.setStoreNb(0);
		
		Block block1 = new Block();
		block1.setFlatNb(5);
		block1.setFloorNb(5);
		block1.setName("B");
		block1.setNbFlatPerFloor(3);
		block1.setStoreNb(0);
		
		Set<Block> blocks = new HashSet<Block>();
		blocks.add(block);
		blocks.add(block1);
		
		Project project = new Project();
		project.setName("Al Shams");
		project.setAddress(address);
		
		block.setProject(project);
		block1.setProject(project);
		
		project.setBlocks(blocks);
		
		
		//producer.getCrud().saveOrUpdate(Arrays.asList(project));
		//List<Project> list = producer.getCrud().list(Project.class);
		//System.out.println(list);
	}
}
