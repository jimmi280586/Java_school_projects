package cd.domain.mediator;

import java.io.IOException;

import utility.persistence.MyDatabase;
import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdDatabase implements CdPersistence
{
	MyDatabase database;

	public CdDatabase(String dbName)
	{
		try
		{
			database = new MyDatabase("CDCollection");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public CdList load() throws IOException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CdList cdList) throws IOException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Cd cd) throws IOException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Cd cd) throws IOException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() throws IOException
	{
		// TODO Auto-generated method stub

	}

}
