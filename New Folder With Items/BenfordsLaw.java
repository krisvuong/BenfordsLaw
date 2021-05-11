/* Name: Kris Vuong and Ronald Ng
 * Date: May 5 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */

import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;
import java.net.URL;

class BenfordsLaw {
  public static void main(String[] args) throws IOException {
    //Declare array
    double[] per = new double[9];
    
    //Menu options
    String loadData = "1";
    String fraudCheck = "2";
    String choice;
    
    //Print main menu
    choice = printMenu();
    
    //User chooses to load a sales file
    if(choice.equals(loadData)){
      //loadFile();
    }
    
    //User chooses to check for fraud
    else if(choice.equals(fraudCheck)){
      BLaw(per);
      exportResults(per);
    }
    
    //User chooses to exit program
    else{
      System.out.println("Program end");
    }
  }
  
  /**
   * Print the main menu
   * 
   * @author - Kris Vuong
   */
  public static String printMenu(){
    Scanner reader = new Scanner(System.in);
    
    //Prompt user choice
    System.out.println("What would you like to do?");
    System.out.println("[1] - load sales data");
    System.out.println("[2] - check for fraud");
    System.out.println("[any other key] - exit program");
    String choice = reader.nextLine();
    
    reader.close();
    
    return choice;
  }

    public static void BLaw(double[] per) throws IOException {
        String filename = "sales.csv";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int [] num = new int [9];
        int count = 0;
        while (line != null){
            line = reader.readLine();
            if (line != null){
                String digit = line.substring(4,5);
                count ++;
                for (int i = 0; i < 9; i++){
                    if (digit.equals(arr[i])){
                        num[i] ++;
                    }
                }
            }
        }
        for (int i = 0; i < num.length; i++){
            per[i] = num[i];
            per[i] = per[i]/count;
            per[i] = Math.round(per[i]*10000);
            per[i] = per[i]/100;
            System.out.println(arr[i] + ": " + per[i] + "%");
        }
        if (per[0] >= 29 && per[0] <= 32){
            System.out.println("There is no fraud");
        }
        else {
            System.out.println("There is fraud.");
        }
        reader.close();
    }
    
  /*
   * Export the digit frequency in a csv
   * 
   * @author - Kris Vuong
   * @param double[] freqArr - the frequency of each digit from 1-9
   */
  public static void exportResults(double[] per) throws IOException{
    Scanner reader = new Scanner(System.in);
    //Create new CSV file
    System.out.println();  //Create break between previous text (visual)
    System.out.println("A CSV file containing the sales digit frequencies was created. \nWhat would you like to name this file? (do not include extension)");
    String fileName = reader.nextLine() + ".csv";
    
    FileWriter fw = new FileWriter(fileName);
    PrintWriter pw = new PrintWriter(fw);
    
    //Write the sales data into the CSV
    pw.println("Digit, Frequency (%)");
    for(int i = 0; i<9; i++){
      pw.print(i+1 + ",");  //left column: digits 1-9
      pw.println(per[i] + ",");  //right column: digit frequencies (%)
    }
    
    //Print save success message and file directory
    System.out.println("\"" + fileName + "\" was exported successfully.");
    URL fileURL = BenfordsLaw.class.getResource(fileName);
    String myURL = fileURL.toString();
    myURL = (myURL.substring(5));
    System.out.println("File directory is " + myURL);
    
    pw.close();
  }
}