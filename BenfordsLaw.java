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
  public static void printMenu(){
    Scanner reader = new Scanner(System.in);
    
    System.out.println("What would you like to do?");
    System.out.println("[1] load \"sales.csv\"");
    System.out.println("[2] check for fraud");
    String choice = reader.nextLine();
    
    reader.close();
  }
}