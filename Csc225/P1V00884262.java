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
    

    
    
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        //get the input of values
        
        FastReader in = new FastReader();
       
        //sets the values of n and limit as the first two inputs
        int n = in.nextInt();
        int limit = in.nextInt();
        
            
        //places the rest of the inputs into an array of numbers    
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            
            
            arr[i] = in.nextInt();
           // System.out.println(arr[i]);
        }
 
        //sort the array
        Arrays.sort(arr);
        
        
        //set the value of the index
        int index = 0;
        
        // number of people approved into a social group
        int score = 0;
        
        
        //LOOP: increament through the indexs
        while (index < n){
            
            score ++;
            
            //System.out.println("initial score = " + arr[index]);
            
            int comparedIn = 1 + index;  
            
            if(index != (n-1)){
            //increament through the array from current index to compare anything to the right of it
                while(comparedIn < n){  
                    
                    // calculates the difference between the arrays and changes it to the absolute value
                    int difference = arr[index] - arr[comparedIn];
                    difference = Math.abs(difference);
                
                
                
                    //if the difference is greater than the limit, exit the loop
                
                    if (difference <= limit){
                    
                        score ++;
                       // System.out.println("forward score = "+ arr[comparedIn]);
                    
                    }else{
                        break;
                    }
                    
                    comparedIn ++;
                
                }
            }
            
            
            //will look at the elements to the left of the array if the current element is not the first one
            if(index != 0){
              
                
                //sets the index to be compared equal to the index to the left of the current
                comparedIn = index - 1;
                // increament through the arry from the current index to compare anything to the left of it
                 while(comparedIn >= 0 ){
                     
                    int difference = arr[index] - arr[comparedIn];
                    difference = Math.abs(difference);
                
                  
                     
                    if (difference <= limit){
                        
                     score ++;
                     
                   // System.out.println("back score = " + arr[comparedIn]);
                     
                        
                    }else{
                        break;
                    }
                     
                        // if the difference has been achieved then add one to the score
                       
                    
                    comparedIn--;
                    
                     
                    
                 }
        
            }
           
            //adds the value to the index to increament through the next value of the array
            index ++;
        
        }
       
       System.out.println(score);
          
    
    }
}