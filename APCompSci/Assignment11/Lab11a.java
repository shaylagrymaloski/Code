import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

//Lab 11a 100 point version

public class Lab11a
{
   public static void main(String[] args)
   
   {
   Scanner input = new Scanner (System.in);
   System.out.print("Enter max number, greater than one, to calculate all the prime numbers in that range: ");
   final int MAX = input.nextInt();
   boolean[] primes= new boolean[MAX];
   computePrimes(primes);
   

   
   }
   public static void computePrimes(boolean primes[])
   {
   
    ArrayList<Integer> list = new ArrayList<Integer>();   
   
   System.out.println("\n\nCOMPUTING PRIME NUMBERS");
   for (int n = 2; n < primes.length; n++)
   {
   
      primes[n] = true;
   
     
   for (int j = 2; j< n; j++){
      
       if (n % j == 0 && n > j) {
          primes[n] = false;
         
       }
     }
       if (primes[n] == true && n != 1) {
             list.add(n);
            }
         
      
    } 
    
      int num = 0;
        for (int i : list) {
            
            DecimalFormat df = new DecimalFormat("0000"); 
            System.out.print(df.format(i) + " ");
            num += 1;
            
            if (num % 16 == 0)
            {
               System.out.println("\n");
               
            }
        }
    
   }      
     
   
   
   
   
   
  
   
 

}