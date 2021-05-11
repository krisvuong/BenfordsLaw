/* Name: Kris Vuong and Ronald Ng
 * Date: May 5 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */
import java.util.Scanner;
import java.io.*;
import javax.activation.MimetypesFileTypeMap;
import java.net.URL;
import java.net.URLConnection;

class BenfordsLaw{
  public static void main(String[] args) throws IOException{
    //System.out.println(loadFile());
    loadFile();
    
  System.out.println("Program terminated");
  }
  
  /**
   * Load input file through user input
   * 
   * @author - Kris Vuong
   * @return String fileDir - String containing directory of user-selected sales file
   */
  public static String loadFile() throws IOException{
    Scanner reader = new Scanner(System.in);
    
    //Declare necessary variables
    String fileDir; //user-inputted directory of sales file
    boolean exists = false;  //if user-inputted file exists
    File temp;  //file containing sales data
    
    //Loop until valid directory is entered
    while(exists == false){
      
      //Prompt file directory
      System.out.println("Enter the sales file directory:");
      fileDir = reader.nextLine();
      
      //Create instance of user-selected file
      temp = new File(fileDir);
      
      //Check if the file exists
      exists = temp.exists();
      if(exists==true){
        return fileDir;  //Return file directory
      }
      else{  //Reprompt if file/directory does not exist
        System.out.println("This file/directory does not exist. Please try again.");
      }
    }
    return "0";  //Arbitrary return value (will never occur)
  }
}