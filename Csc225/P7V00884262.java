//Programming Assignment 7
//Shayla Grymaloski
//V00884262


import java.io.*;
import java.util.*;
import java.io.BufferedWriter.*;

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
    
    
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        //get the input of values
        
        FastReader in = new FastReader();
       
        //sets the values of n and limit as the first two inputs
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] array = new int[n];
        
        for (int i = 0; i< n; i++){
            
            array[i] = in.nextInt();
            
        }
        //creates a buffer reader object
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
        //creates a tree class
        TreeSet tree = new TreeSet<Integer>();
        // adds values to the tree
        for(int i = 0; i< k; i++){
        
                tree.add(array[i]);
        }
        
       
        //interates through the array 
        for(int j = 0; j< (n-k)+1; j++){
             
            int firstElement = array[j];
            
            Object element = (Integer)firstElement;
            //adds k elements to the tree
            
            
            //takes the first two highest values
            int val = (Integer)tree.pollLast();
            int val2 = (Integer)tree.pollLast();
            int sum = val+ val2;
            //adds the values back to the tree
            tree.add(val);
            tree.add(val2);
            
            if(j < n-k){
            
            //removes the first element in the k value
            tree.remove(element);
            
            //add next element of the arrau
            tree.add(array[k+j]);
            }
            
            String strSum = Integer.toString(sum)+" ";
            
            //print out the sum value using the buffer writer class
            out.write(strSum ,0,strSum.length());
        }
        
        
        
        
        
       
        out.flush();
        
    }
    
}