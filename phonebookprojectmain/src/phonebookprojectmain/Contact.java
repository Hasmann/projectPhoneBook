package phonebookprojectmain;

public class Contact {
    
    //Declaration of variables
        private String firstName;
	private String lastName;
	private String  phoneNumber;
        private String address;
        private String city;
        
             public Contact(){}
// getters  and setters for initializing the variables as the access modifiers are private
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
         
              return phoneNumber;		
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
        
        public String getCity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
          
        public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
        //constructor for initializing
        	public Contact(String lastName, String firstName, String phoneNumber,String city,String address) 
                {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
                this.city = city;
                this.address = address;
              
	}  
           //method for adding all contacts to the file   
     public String putallcontacts(){
     
     return String.format("%s--%s--%s--%s--%s",firstName.toUpperCase().trim(),lastName.trim(),address.toUpperCase().trim(),city.toUpperCase().trim(),phoneNumber);
     } 
        
        
   
}

