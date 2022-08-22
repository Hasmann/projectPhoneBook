
package phonebookprojectmain;

import java.util.*;
import java.io.*;
public class phoneBook extends Contact {
 
    //putting the contact class into an arraylist
private List<Contact> myphoneBook=new ArrayList<Contact>();
//declaring and initializing the reference variable myphoneBook.
    public void setPhoneBook(List<Contact>obj)
    {
        myphoneBook=obj;
    }
    public List<Contact>getPhoneBook()
    {
        return  myphoneBook;
    }
    //adding all values in the contact class into the myphoneBook class
    public void  addContact(Contact contactObj)
    {
         myphoneBook.add(contactObj);
    }
 
    public List<Contact> viewAllmyContacts()
    {
        return  myphoneBook;
    }
    
   public Contact viewContactGivenPhone(String phoneNumber)
    {
        Contact obj=new Contact();
        for(Contact obj1:myphoneBook)
        {
            if(obj1.getPhoneNumber()==phoneNumber)
            {
                obj=obj1;
            }
        }
        return obj;
    }
 
  
    
    
    

    
    
    
    
}
