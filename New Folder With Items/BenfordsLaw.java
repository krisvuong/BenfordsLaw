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
    //temp array
    double[] temp = {29.10,32.94,10.67,4.05,5,6,7,8,9};
    
    //Create new CSV file
    FileWriter fw = new FileWriter("DigitFrequency.csv");
    PrintWriter pw = new PrintWriter(fw);
    
    pw.println("Digit, Frequency (%)");
    for(int i = 0; i<9; i++){
      pw.print(i+1 + ",");
      pw.println(temp[i] + ",");
    }
    
    pw.close();
  }
}