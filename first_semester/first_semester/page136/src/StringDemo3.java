
public class StringDemo3
{

   public static void main(String[] args)
   {
      String first = "JImmi Østergaard Andersen";
      String address = "Højkildevej 50 ";
      String city = "Daugaard ";
      String zip = "8721 ";
      String phone = "23368303";
      String sub = phone.substring(0, 8);
      String school = "ICT ";
      
      System.out.println("name" + first + "\n" + "address " + address + zip + city + "\n" + "phone number " + sub + "\n" + "school " + school + "engeneer");
           
   }

}
