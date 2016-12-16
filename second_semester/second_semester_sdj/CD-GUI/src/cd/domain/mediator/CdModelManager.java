package cd.domain.mediator;

import java.io.IOException;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdModelManager implements CdModel{

	private String TEXT_FILE_NAME = "src/cds.txt";
	private CdPersistence cdpersistence;
	private CdList cdlist;
	
	public CdModelManager() throws IOException 
	{
		 try {
			 this.cdpersistence = new CdTextFile(this.TEXT_FILE_NAME);
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
			 try {
			 this.cdlist = cdpersistence.load();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
	}

	@Override
	public CdList getAll() 
	{
		
		return this.cdlist;
	}

	@Override
	public void addCD(Cd cd) 
	{
		this.cdlist.addCd(cd);
		
	}

	@Override
	public Cd removeCD(String title)
	{
		
		return this.cdlist.removeFirstCdByTitle(title);
	}

	@Override
	public CdList getCD(String title)
	{
		
		return this.cdlist.getCdsByTitle(title);
	}

	@Override
	public int getNumberOfCds()
	{
		
		return this.cdlist.getNumberOfCds();
	}

	
}
