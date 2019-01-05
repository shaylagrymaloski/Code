import java.util.ArrayList;
import java.text.DecimalFormat;

public class PrimeGenerator {
    public static void main(String[] args) {
        int max = 100;

        ArrayList<Integer> list = new ArrayList<Integer>();

        // loop through the numbers and set them as true
        for (int n = 1; n < max; n++) {
            boolean prime = true;

        // loop through number 2 and up to see if they divide by 
            for (int j = 2; j < n; j++) {
                if (n % j == 0 && n > j) {
                    prime = false;
                    }
            }
            if (prime && n != 1) {
                list.add(n);
            }
        }
        int num = 0;
        for (int i : list) {
            
            DecimalFormat df = new DecimalFormat("0000"); 
            System.out.print(df.format(i) + " ");
            num += 1;
            
            if (num % 15 == 0)
            {
               System.out.println("\n");
               
            }
        }
    }
}