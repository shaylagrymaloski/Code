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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
        
        */
        //
       
        FastReader in = new FastReader();
       
        //sets the values of n as the first  input
        int n = in.nextInt();
       
        //places the rest of the inputs into an array of numbers    
        int[] arr = new int[n];
        long medium = 1;
        long m = 1;
        //create priority queues here, max and min
        //min priority queue
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        // max priority queue
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        //place the first medium to the min queue
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
         
            if(i == 0){
             
                m = arr[i];
                
            }else if(i==1){
                
                
                if(arr[i] > m){
                    pqMin.add(arr[i]);
                    pqMax.add((int)m);
                
                   
                }else{
                    pqMin.add((int)m);
                    pqMax.add(arr[i]);
                     m = arr[i];
                }
                
                
            
            }else   {
              
                if(arr[i] >= m){
                    //if current value is > medium place to min queue
                    
                    pqMin.add(arr[i]);
                  
                }else {
                    //if current value is < medium place to max queue
                    pqMax.add(arr[i]);
                    
                }
                
                if((pqMin.size()-pqMax.size())==2 || (pqMin.size()-pqMax.size())== -2){
                 
                    if(pqMax.size() >pqMin.size()){
                        //moves an element of max to min if max is too big
                        pqMin.add(pqMax.remove());
                        
                        
                    }else{
                       pqMax.add(pqMin.remove());
                        
                    }
                  
                }
                if(pqMin.size()==pqMax.size()){
                    
                    m = pqMax.peek();
                    
                }else if((pqMin.size()-pqMax.size()) == 1){
                    m = pqMin.peek();
                   
                }else if((pqMin.size()-pqMax.size()) == -1){
                    m = pqMax.peek();
                }
            }
          // System.out.println("value of m = " +m);
            medium = (medium * m ) % (10*10*10*10*10*10*10*10*10 + 7);
             
        }

       System.out.println(medium);
        
    }
}


