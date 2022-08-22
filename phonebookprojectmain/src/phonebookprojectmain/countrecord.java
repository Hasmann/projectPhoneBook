package phonebookprojectmain;

import java.io.*;
import java.util.*;

public class countrecord {

    void counting(){
    //declaring and initializing the variable count
     int count =0;
      try{ 
           //opening the given file in the bracket below
          File nf = new File("myphonebookmaintenance.txt");
         //declaring and initializing scanner to scan through the files
         Scanner Fc = new Scanner(nf);
          //using the initialized scanner to scan through the file
         while(Fc.hasNextLine()){
             //iterating through all the lines in the file
         Fc.nextLine();
         //if any line in the file is occupied increase variable count by 1
         count++;
      
         }
         //printing out the variable count
             System.out.println("THE TOTAL NUMBER OF CONTACTS ARE:"+count);
             //closing the file
          Fc.close();
         }
      
      catch(Exception e){
          System.out.println("THE FILE DIDNT OPEN PROPERLY");
      }
        
    }

}
