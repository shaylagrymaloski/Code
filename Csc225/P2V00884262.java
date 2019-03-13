import java.io.*;
import java.util.*;

public class Solution {

     // fast reader provided by instructor   
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    
 
    
    public static long computeVal(int[] a, int[] b, int n){
       long result = 0;
        
        //runs if n is even
        if(n%2 == 0){
            
            //allocating the new splitted arrays
            int[] a1 = new int[n/2];
            int[] a2 = new int[n/2];
            int[] b1 = new int[n/2];
            int[] b2 = new int[n/2];
            
            //split A to two arrays
            
            for(int i = 0;i < (n/2); i++){
                
                a1[i] = a[i];
            
            //    System.out.println("This is at a1 "+a1[i]);
               
            }
          //  System.out.println();
           //System.out.println("running");
            for(int i = 0; i < (n/2); i++){
               
                a2[i] = a[(n/2)+i];
               
              //   System.out.println("This is at a2 "+a2[i]);
               
            }
          //  System.out.println();
            //split B to two arrays
            
             for(int i = 0;i <( n/2); i++){
                
                b1[i] = b[i];
                // System.out.println("This is at b1 "+b1[i]);
                
            }
          //  System.out.println();
            for(int i = 0; i < (n/2); i++){
                b2[i] = b[(n/2)+i];
              //  System.out.println("This is at b2 "+b2[i]);
            }
            // System.out.println();
            // System.out.println("end of recursion");
            // System.out.println();
            //compute using fomula
            
            result = computeVal(a1, a2, n/2) + computeVal(b1, b2, n/2) + computeVal(a1, b2, n/2) + computeVal(b1, a2, n/2);
            
         //   result = computeVal(a1, a2, n/2);
        
        }else{
            //runs if n is an odd number
            int i = 0;
            while(i<n){
                
                result = result + a[i]*b[i];
                i++;  
                
            }
          
        }
       
        return result;   
      
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        long result = 0;
        FastReader in = new FastReader();
       
        //sets the values of n and limit as the first two inputs
        int n = in.nextInt();
       
       // System.out.println(n);
            
        //places the rest of the inputs into an array of numbers    
        int[] firstArr = new int[n];
        for(int i = 0; i < n; i++){
          firstArr[i] = in.nextInt();
           // System.out.println(firstArr[i] + "First Array");
        }
        
        
        //places second row of the array into an array of numbers
        
         int[] secondArr = new int[n];
         for(int i = 0; i < n; i++){
            
            secondArr[i] = in.nextInt();
             // System.out.println(secondArr[i] + "Second Array");
         }
       
        result = computeVal(firstArr, secondArr, n);
        
       
        
        System.out.println(result);
        
        
    }
}