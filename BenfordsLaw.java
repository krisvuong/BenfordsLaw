/* Name: Kris Vuong and Ronald Ng
 * Date: May 5 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */

import java.io.*;
import java.util.Scanner;

class BenfordsLaw{
  public static void main(String[] args) throws IOException{
    //temp
    exportResults();
  }

  
//add methods here
  
  /**
   * Print the main menu
   * 
   * @author - Kris Vuong
   */
  public static void printMenu(){
    Scanner reader = new Scanner(System.in);
    
    System.out.println("What would you like to do?");
    System.out.println("[1] load \"sales.csv\"");
    System.out.println("[2] check for fraud");
    String choice = reader.nextLine();
    
    reader.close();
  }
  
  /*
   * Export the digit frequency in a csv
   * 
   * @author - Kris Vuong
   * @param double[] freqArr - the frequency of each digit from 1-9
   */
  public static void exportResults() throws IOException{
    //temporary array
    double[] temp = {29.10,32.94,10.67,4.05};
    
    //Create new CSV file
    FileWriter fw = new FileWriter("DigitFrequency.csv", true);  //"true": if the file already exists, then data is added to the file rather than overwriting current data
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter (bw);
    
    //Write digit information into DigitFrequency.csv
    pw.println();    //Start a new row for each customer's data
    for(int i = 1; i<10; i++){
      pw.println(i);
    }
    pw.close();    //Close PrintWriter
    System.out.println("Hi");
  }
}