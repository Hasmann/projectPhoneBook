package phonebookprojectmain;
import java.util.*;
import java.io.*;
 
public class Phonebookprojectmain {
    //initializing the variable below
	public static String msg_dialogue="PRESS: \n 1-Add contact \n 2-Display All Records\n 3-Search\n 4-Count-Records\n 5-Delete-Records\n 6-Modify-Records\n 7-Exit ";
       
	public static void main(String[] args) {	
            
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t***** Welcome To MyPhone Book *****");
                //invoking and making a reference variable of the Scanner class (see line 21-53)
		Scanner input=new Scanner(System.in);	
                 //invoking and making a reference variable of the Scanner class of the search method(see line 65. and line 78.)
                Scanner display = new Scanner(System.in);
                //invoking external java class phoneBook
                phoneBook pnb=new phoneBook();
              
        //infinity loop for the whole progam.         
        for(;;){
               System.out.print("**********'Main Menu'**********\n "+msg_dialogue+"\n");
               System.out.printf("ENTER YOUR CHOICE:");
               //scanner input for conditional statement below
                 String command=input.nextLine().trim();				
 
    
    
	//conditional statement block for if input command ==1	
        
        //METHOD FOR WRITTING INTO THE FILE
         if (command.equals("1")){
         //invoking externaljava class contact
	            Contact con=new Contact();		 
                    System.out.println("Enter Your First Name: ");
                    con.setFirstName(input.nextLine());
                    System.out.println("Enter Your Last Name: ");
                    con.setLastName(input.nextLine());
                    System.out.println("Enter Your Address: ");
                    con.setaddress(input.nextLine());
                    System.out.println("Enter Your City: ");
                    con.setcity(input.nextLine());	
                     System.out.println("Enter Your Phone Number: ");
                    con.setPhoneNumber(input.nextLine());
                    pnb.addContact(con);
                                                      
		//creating a file using inbuilt method Filewriter			
	 try{
             FileWriter fw = new FileWriter("myphonebookmaintenance.txt",true);
             BufferedWriter out = new BufferedWriter(fw);
             out.write(con.putallcontacts().trim());
             out.newLine();
             out.close();
         }
         catch(Exception e){
             System.out.println("not created");
         }
         
         }
            
                                 
                   
     
     
       //conditional statement block for if input command ==2	
     
       //METHOD FOR DiSPLAYING THE CONTENTS OF A FILE
           else if(command.equals("2")){
        //invoking external class display
       display disp = new display();
       //calling openfile method in external class display
        disp.openfile();
         //calling close method in external class display
       disp.close();
         }   
    
    
        
         //conditional statement block for if input command ==3
    
      //METHOD FOR SEARCHING THE GIVEN FILE THE FILE
          else if (command.equals("3")){
              System.out.print("Type in the name you are searching for :\n:");
	      String searchfile=display.nextLine().trim();
	       searchfile.toLowerCase();
	    try{
                //opening the file you want to search
		File nf=new File("myphonebookmaintenance.txt");
                //using a scanner to scan through the file
		Scanner s2=new Scanner(nf);
                //scanning through the contents of a file
		    while(s2.hasNextLine()){
                        //iterating through the lines of a file
		        String found=s2.nextLine();
                        //if the search field is equal to that of the contents in the file 
			if (found.toLowerCase().indexOf(searchfile)>=0){
                            //display the contents
			 System.out.print("Result: "+found+"\n");
			 }
		         }
		        }
            //catch any errors in the block of code above
                    catch(Exception e)
                      {
                          e.printStackTrace();
                        }	
 
		}
                                
    
    
    
        //conditional statement block for if input command ==4
    
        //METHOD FOR COUNTING THE RECORDS IN A FILE
    
          else if (command.equals("4")) {
    
         //invoking external class countrecord and giving it a reference variable
         countrecord ctr = new  countrecord();
        //calling counting method in external class counting-record
         ctr.counting();
         }
        
          
          
      
      //conditional statement block for if input command ==5
    
      //METHOD FOR DELETING THE RECORDS IN A FILE
    
           else if (command.equals("5")){
          //invokong main method delrec()
          delrec(4);
         
              }
     
     
     
     
      //conditional statement block for if input command ==6
    
      //METHOD FOR MODIFYING THE RECORDS IN A FILE
    
         else if (command.equals("6")){
          
            editrec(4);
          }
     
     
     
     
       //conditional statement block for if input command ==7
    
      //METHOD FOR EXITING THE PPROGRAM  
     
          else if (command.equals("7")){
            System.out.println("Good Bye User....");
            System.exit(0);
	}
    
    
    
    
    
    //else Statement For The Conditinal statements above
     else{					
	System.out.print("Unknown command ! Try again \n:");
	}
 
		}
 
	}
        
        public static void delrec(int position)
 {
     String filepath="myphonebookmaintenance.txt";
     String tempfile="myphonebookmaintenancedelete.txt";
     File oldfile=new File(filepath);
     File newfile=new File(tempfile);
     Scanner input=new Scanner(System.in);
        String removeterm="";
        //input provided for phone number to delete
        //the essece of using the phone number other than other fields is the phone number is unique to every record
        System.out.print("ENTER RECORD'S PHONE NUMBER TO DELETE:");
        removeterm=input.nextLine();
     String fname="";
     String lname="";
     String phone="";
     String city="";
     String add="";
     String currentline=" ";
     String data[];
      try
      {
      FileWriter fw=new FileWriter(tempfile,true);   
      BufferedWriter bw=new BufferedWriter(fw);
      PrintWriter pw =new PrintWriter(bw);
      FileReader fr=new FileReader(filepath);
      BufferedReader br=new BufferedReader(fr);
      while((currentline=br.readLine())!=null)
      {
          //the split shows to check after the given condition
         data= currentline.split("--");
          if(!(data[position]).equalsIgnoreCase(removeterm))
          {
            pw.println(currentline);
          }
      }
      //after running what is inside the while loop we have to close the io classes invoked
      pw.flush();
      pw.close();
      fr.close();
      br.close();
      bw.close();
      fw.close();
      oldfile.delete();
      //renaming the new file to the oldfile
      File dump=new File(filepath);
      newfile.renameTo(dump);
      System.out.println("DELETED");
      
      }
      catch(Exception e)
      {
          System.out.println("error1"+ "");
      }
 }
        
         //same ideology used in the delete method.But instead we replace with a new record after deleting
  public static void editrec(int position)
 {
     Contact con=new Contact();
     String filepath="myphonebookmaintenance.txt";
     String tempfile="myphonebookmaintenancedelete1.txt";
     File oldfile=new File(filepath);
     File newfile=new File(tempfile);
     Scanner input=new Scanner(System.in);
        String removeterm="";
        //input provided for phone number to delete
        System.out.print("ENTER RECORD'S PHONE NUMBER TO EDIT:");
        removeterm=input.nextLine();
     String fname="";
     String lname="";
     String add="";
     String city="";
     String phone="";
     String currentline=" ";
     String data[];
     String lastName;
     System.out.print("ENTER NEW LASTNAME:");
     lastName=input.nextLine();
     String firstName;
     System.out.print("ENTER NEW FIRSTNAME:");
     firstName=input.nextLine();
    String address;
     System.out.print("ENTER NEW ADDRESS:");
     address=input.nextLine();
     String city2;
     System.out.print("ENTER NEW CITY:");
     city2=input.nextLine();
       String phoneNumber;
     System.out.print("ENTER NEW PHONE NUMBER:");
     phoneNumber=input.nextLine();
      try
      {
      FileWriter fw=new FileWriter(tempfile,true);   
      BufferedWriter bw=new BufferedWriter(fw);
      PrintWriter pw =new PrintWriter(bw);
      FileReader fr=new FileReader(filepath);
      BufferedReader br=new BufferedReader(fr);
      while((currentline=br.readLine())!=null)
      {
         data= currentline.split("--");
          if(!(data[position]).equalsIgnoreCase(removeterm))
          {
            pw.println(currentline);
           pw.println(firstName.toUpperCase() +"--"+lastName+"--"+address.toUpperCase()+"--"+city.toUpperCase()+"--"+phoneNumber);
          }
      }
      pw.flush();
      pw.close();
      fr.close();
      br.close();
      bw.close();
      fw.close();
      oldfile.delete();
      File dump=new File(filepath);
      newfile.renameTo(dump);
      System.out.println("EDITTED SUCCESSFULLY");
      
      }
      catch(Exception e)
      {
          System.out.println("error1"
                  + "");
      }
 }

        
}