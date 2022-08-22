package phonebookprojectmain;

import java.util.*;
import java.io.*;
public class display {
 
    //declaring Scanner df
   public Scanner df;
  
  void  openfile(){
  //opening the given file in the bracket below
     try{
     File nf = new File("myphonebookmaintenance.txt");
     //using the initialized scanner to scan through the file
     df = new Scanner(nf);
     //scanning through all the fields in a file
     while(df.hasNextLine()){
         System.out.println("");
         //printing out all the columns  in a given file 
        System.out.println("CONTACTS:"+df.nextLine());
     }
      
      
     }
      catch(Exception e){
         System.out.println("IT DIDNT PRINT OUT");
     }
  }
//method to close the file.
  public void close(){
  df.close();
  }
    
 
  
    
    
    
    
    
    
    
    
    
    
    
    
}
