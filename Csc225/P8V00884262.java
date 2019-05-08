import java.io.*;
import java.util.*;
import java.util.Queue; 

public class Solution {

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
    
    static class Cell{
        boolean cellStatus;
        int distance;
        int row;
        int col;
        boolean canPass;
        public Cell(boolean cellStatus, int distance, int col, int row, boolean canPass){
            this.row = row;
            this.col = col;
            this.cellStatus = cellStatus;
            this.distance = distance;
            this.canPass = canPass;
        }
        
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader in = new FastReader();
        int n = in.nextInt();
      
        //create a nxn matrix
        Cell[][] table = new Cell[n][n];
        
        
        Queue<Cell> queue = new LinkedList<>(); 
        String element;
        
        
        Cell soldier = new Cell(false, n, 0,0,false);
        Cell king = new Cell(false, n, 0,0,false);
        Cell curr = new Cell(false, n, 0,0,false);
        
        //creates the multidimentional array
        for(int i=0; i< n; i++){
            element = in.next();
            
            for(int j =0; j< n; j++){
                char letter = element.charAt(j);
                table[i][j] = new Cell(false, n, 0, 0,false);
               
                if(letter == 'S'){
                    
                    soldier.cellStatus = true;
                    soldier.row = i;
                    soldier.col = j;
                    soldier.distance = 1;
                    
                  
                }
                if(letter == 'K'){
                 
                    king.cellStatus = false;
                    king.row = i;
                    king.col = j;
                    king.distance = 0; 
                    king.canPass = true;
                    
                    table[i][j].cellStatus = false;
                    table[i][j].row = i;
                    table[i][j].col = j; 
                    table[i][j].distance = 0;
                    table[i][j].canPass = true;
                    
                }
                if(letter == '-'){
                
                    table[i][j].cellStatus = false;
                    table[i][j].row = i;
                    table[i][j].col = j; 
                    table[i][j].distance = 0;
                    table[i][j].canPass = true;
                    
                }
                if(letter == 'X'){
                    table[i][j].cellStatus = false;
                    table[i][j].row = i;
                    table[i][j].col = j;
                    table[i][j].distance = 0;
                    table[i][j].canPass = false;
                    
                }
                
        }  //end of for loop making the array
            
        } //end of other for loop making the array
        
        
        int count = 0;
        boolean kingFound = false;
        curr = soldier;
        
        while(kingFound == false){
            
            int row = curr.row;
            int col = curr.col;
            boolean top = false;
            boolean bottom = false;
            boolean left = false;
            boolean right = false;
            if(curr.row == king.row && curr.col == king.col){
               kingFound = true;
               
               System.out.println(curr.distance -1);
           }
           
        //checking to see if the current value is on the edge
            if(row == 0){
                top = true;
            }if(col == 0){
                left = true;
            }if(col == (n-1)){
                right = true;
            }if(row == (n-1)){
                bottom = true;
            }
            
            
            
            
            if(top != true){
                
                //adding the value above the element
                if(table[row-1][col].canPass == true && table[row-1][col].cellStatus ==false){
                   
                    table[row-1][col].cellStatus =true;
                    table[row-1][col].distance = curr.distance +1;
                    queue.add(table[row-1][col]);
                    
                }
                
            }if(bottom != true){
                //adding the value below the element
                if(table[row+1][col].canPass == true && table[row+1][col].cellStatus ==false ){
                  
                    table[row+1][col].cellStatus =true;
                    table[row+1][col].distance = curr.distance +1;
                    queue.add(table[row+1][col]);
                    
                }
                
            }if(left!= true){
                if(table[row][col-1].canPass == true && table[row][col-1].cellStatus ==false){
                //adding the value to the left of the element
                  
                    table[row][col-1].cellStatus =true;
                    table[row][col-1].distance = curr.distance +1;
                    queue.add(table[row][col-1]);
                    
                }
                
            }if(right!= true){
                if(table[row][col+1].canPass == true && table[row][col+1].cellStatus ==false){
                  
                    table[row][col+1].cellStatus =true;
                    table[row][col+1].distance = curr.distance +1;
                    queue.add(table[row][col+1]);
                    
                    
                }
                
            }
            
            
            
            if(queue.peek() == null){
                System.out.println("IMPOSSIBLE");
                kingFound = true;
                break;
            }
            
            curr = queue.remove();
            
            
            
            
        }

        
    }
}