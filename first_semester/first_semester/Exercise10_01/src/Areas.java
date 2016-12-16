
public class Areas 
{
	 private double Width;
	   private double Height;
	   
	   public void setWidth(double Width)
	   {
	      this.Width = Width;
	   }
	   
	   public double getWidth()
	   {
	      return this.Width;
	   }
	   public void setHeight(double Height)
	   {
	      this.Height = Height;
	     
	   }
	   
	    public double getHeight()
	   {
	      return this.Height;
	   }

	    
	   public double getArea()
	   {
	      return this.Width * this.Height;
	   }
}
