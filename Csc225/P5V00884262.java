import java.io.*;
import java.util.*;
import java.util.Arrays.*;


public class Solution {
    private static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
          this.second = second;
        }
        
        
    }

     private static class Item{
        int key;
        int data;
        int data2;

        public Item(int key, int data, int data2) {
            this.key = key;
            this.data = data;
            this.data2 = data2;
        } 

        @Override
        public String toString() {
            return "(" + key + ", " + data + ")"; //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
      static void usefulCountingSort(Item[] A, int k){
        
        ArrayList< ArrayList<Item> > C = new ArrayList<>();
        
        for(int i = 0; i < k; i++)
            C.add(new ArrayList<>());
        
        for(int i = 0; i < A.length; i++){
            int key = A[i].key;
            C.get(key).add(A[i]); //takes O(1) time
        }
        
        int index = 0;
        for(int i = 0; i < k; i++)
            for(int j = 0; j < C.get(i).size(); j++)
                A[index++] = C.get(i).get(j);
    }

    
    public static Pair[] inputGenerator(int n){ /* be careful to not modify this function */
    long last = 5000011;
    long mult1 = 5000087;
    long mult2 = 5000167;

    Pair[] arr = new Pair[n];
    for(int i = 0; i < n; i++){
        last = (last * mult1 + mult2)%n;
        int x = (int)last;
        last = (last * mult2 + i + mult1)%n;
        int y = (int)last;
        arr[i] = new Pair(x, y);
    }
    return arr;
}

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        Pair[] inputArray = inputGenerator(n);
     
 
        //creating item object array for the first and second array
        Item[] A = new Item[inputArray.length];

        
        //adds the first key and array element to the item array
        for(int i = 0; i < A.length; i++){
          
            A[i] = new Item((inputArray[i].second+i)%n, inputArray[i].first, inputArray[i].second);
         
        }
       
        //sorts the arrays with the object arrays
        usefulCountingSort(A,n);

    
        //add the second key and array element to the item array
         for(int i = 0; i < A.length; i++){
            
            A[i] = new Item((A[i].data+(2*i))%n, A[i].data, A[i].data2);
           
        }
        
        //sorts the arrays with the object arrays
        usefulCountingSort(A,n);
     
      
        //prints out the result
          for(int i = 0; i < A.length; i = i+k){
            System.out.println("("+A[i].data+","+A[i].data2 +")");
        }
    
    }
}