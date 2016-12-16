
public class Address 
{

		private String streetAddress;
		private int postCode;
		
		public Address(String streetAddress, int postCode) 
		{
			super();
			this.streetAddress = streetAddress;
			this.postCode = postCode;
		}

		public String getStreetAddress() {
			return streetAddress;
		}

		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}

		public int getPostCode() {
			return postCode;
		}

		public void setPostCode(int postCode) {
			this.postCode = postCode;
		}

		public Address copy()
		{
			return new Address(this.streetAddress, this.postCode);
		}
		
		public boolean equals(Address obj) {
			// TODO Auto-generated method stub
			return this.streetAddress.equals(obj.streetAddress) 
					&& this.postCode == obj.postCode;
		}

		

	

		
		
		
}
