package interfaces;

public class Implementation
{
	public Implementation()
	{
		System.out.println( "Here is the implementation class" );
	}
	
	
	public VatResponse vat( Vat v )
	{
		System.out.println( "vat called" );
   	 
		double amount = v.getArgs0();
		double vat = 0.25 * amount;
   
		VatResponse res = new VatResponse();
		res.set_return( vat );
		
		return res;
	}
	
	
	public MaxResponse max( Max m )
	{
        System.out.println( "max called" );
   	 
        int a = m.getArgs0();
        int b = m.getArgs1();
        
        int max = a > b ? a : b;
        
        MaxResponse res = new MaxResponse();
        res.set_return( max );
        
        return res;
	}
}
