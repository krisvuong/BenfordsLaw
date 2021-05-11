/* Name: Kris Vuong and Ronald Ng
 * Date: May 5 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */

class BenfordsLaw{
  public static void main(String[] args){
    
  }

  //add methods here
  
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
}