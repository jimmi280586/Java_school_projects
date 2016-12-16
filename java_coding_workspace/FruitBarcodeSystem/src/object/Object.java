package object;

public class Object 
{
	private String name;
	private int barcode;
	private int plu;
	private int id;
	
	public Object(String name, int barcode, int plu, int id)
	{
		this.name = name;
		this.barcode = barcode;
		this.plu = plu;
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getBarcode() 
	{
		return barcode;
	}

	public void setBarcode(int barcode) 
	{
		this.barcode = barcode;
	}

	public int getPlu() 
	{
		return plu;
	}

	public void setPlu(int plu) 
	{
		this.plu = plu;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
}
