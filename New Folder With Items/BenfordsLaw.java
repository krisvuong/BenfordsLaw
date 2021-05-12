/* Name: Kris Vuong and Ronald Ng
 * Date: May 12 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */

import java.io.*;
import java.util.Scanner;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BenfordsLaw extends Application {
  @Override public void start(Stage stage) throws IOException {
    String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    //the numbers for x-axis
    stage.setTitle("Number Frequency");
    //creates title of window
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    //creates x and y axis
    final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
      //format of x and y
    bc.setTitle("Number Frequency");
    //creates title of graph
    xAxis.setLabel("Number");
    //label for x-axis       
    yAxis.setLabel("Percentage");
    //label for y-axis
    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    //creates one bar
    double frequency[] = new double[9];
    String filename = "sales.csv";
    frequency = BLaw(frequency, filename);
    for (int i = 0; i < arr.length; i++){
      //goes through every number
        series1.getData().add(new XYChart.Data<>(arr[i], frequency[i]));
        //creates each value
    }
    Scene scene  = new Scene(bc,800,600);
    //creates size of window
    bc.getData().addAll(series1);
    //makes of the bar for the graph
    stage.setScene(scene);
    stage.show();
}
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        //Declare variables/array
        double[] per = new double[9];  //contains frequency(%) of each digit 1-9
        String fileDir = "no file selected";  //contains directory of user-selected file
        
        //Menu options
        String loadData = "1";
        String fraudCheck = "2";
        String choice = "1";  //user choice
        
        //Print main menu
        while((choice.equals(loadData))||(choice.equals(fraudCheck))){  //loop while user enters 1 or 2
          choice = printMenu(fileDir, reader);
          
          //User chooses to load a sales file
          if(choice.equals(loadData)){
            fileDir = loadFile(reader);
          }
          
          //User chooses to check for fraud
          else if(choice.equals(fraudCheck)){
            per = BLaw(per, fileDir);
            //gets the digit frequencies
            if(per[0] <= 100){  //true: they have already loaded a file // false: they have not loaded a file
              for (int i = 0; i < per.length; i++){
                //goes through each digit
                System.out.println((i + 1) + ": " + per[i] + "%");
                //gives frequency of each digit
              }
              if (per[0] >= 29 && per[0] <= 32){
                System.out.println("There is no fraud");
              }
            else {
                System.out.println("There is fraud.");
              }
              //tells if there is fraud or not
              System.out.println("To continue program close the graph");
              //tells user to close graph if they want to continue the program
              launch(args);
              //creates graph
              exportResults(per, reader);  //export DigitFrequency.csv IF a sales file is loaded
            }
          }
        }
        //User chooses to exit program
        System.out.println("Program end");
        reader.close();
    }
      
      /**
       * Print the main menu
       * 
       * @author - Kris Vuong
       * @return String choice - String containing menu choice
       */
      public static String printMenu(String fileDir, Scanner reader){
        //Prompt user choice
        System.out.println("What would you like to do?");
        System.out.println("[1] - load sales data");
        System.out.println("[2] - check for fraud in: [" + fileDir + "]");
        System.out.println("[any other key] - exit program");
        String choice = reader.nextLine();
        return choice;
      }
      
      /**
       * Load input file through user input
       * 
       * @author - Kris Vuong
       * @return String fileDir - String containing directory of user-selected sales file
       */
      public static String loadFile(Scanner reader) throws IOException{
        
        //Declare necessary variables
        String fileDir; //user-inputted directory of sales file
        boolean exists = false;  //true if user-inputted file exists
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
    
      
      /*
      * @author - Ronald Ng 
      * Description - Finds the distributions of the first digits
      *
      * @param - per the double array that is used to stores the percent distrubtions of the digits, fileName the name of the file to examine the distrubtions of the digits
      * @return - returns the double array that contains all the percent distrubtiond
      */
        public static double[] BLaw(double[] per, String fileName) throws IOException {
          try{
            String filename = fileName;
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
                per[i] = Math.round(per[i]*1000);
                per[i] = per[i]/10;
            }
            reader.close();
            return per;
          }
          catch(FileNotFoundException e){
            System.out.println("A file must be loaded before checking for fraud.");
            double err[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
            return err;
          }
          catch(Exception e){
            double err[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
            return err;
          }
        }
        
      /*
       * Export the digit frequency in a csv
       * 
       * @author - Kris Vuong
       * @param double[] freqArr - the frequency of each digit from 1-9
       */
      public static void exportResults(double[] per, Scanner reader) throws IOException{
        //Prompt name of CSV file
        System.out.println();  //Create visual break between previous text
        System.out.println("A CSV file containing the sales digit frequencies was created. \nWhat would you like to name this file? (do not include extension)");
        String fileName = reader.nextLine() + ".csv";
        
        //Create new CSV file
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
