/* Name: Kris Vuong and Ronald Ng
 * Date: May 5 2021
 * Teacher: Mr. Ho
 * Description: Benford's Law (Methods Part 2)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class BenfordsLaw {
    public static void main(String[] args) throws IOException {
        Blaw();
    }
    
    public static void Blaw() throws IOException {
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
        double [] per = new double [9];
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
}