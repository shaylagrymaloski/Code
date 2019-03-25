import java.io.*;
import java.util.*;
import java.util.ArrayList.*; 


public class Solution {

    //class given by the instructor

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

 
    static class Canidates{

        String name;
        int score;

        public Canidates(String name, int score){

            this.name = name;
            this.score = score;

        }


    }

        

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        FastReader in = new FastReader();
        int n = in.nextInt();
        String name = in.next();
        int index = 0;

        
        ArrayList <String> list = new ArrayList<String>();
       
        list.add(name);


        Canidates[] Votes = new Canidates[n];
        Votes[index] = new Canidates(name, 1);
        index++;
        

        for(int i = 1; i< n; i++){

            name = in.next();

            //if the list contains the ballot name
            //add 1 to the score of the class at the index
            if(list.contains(name)){
                   int canIndex = list.indexOf(name);
                 Votes[canIndex].score++;


            }
            //add to the array
            //add to the class array
            else{
                
                list.add(name);
                //adds a new canidate to the votes array
                Votes[index] = new Canidates(name, 1);
                index++;
                
        

            }

     

        
        }
    
        
        //print out the score that is the highest
        int highestScore = Votes[0].score;
        int highScoreIndex = 0;
        
        //iterates through the list to find the highest schore
         for(int i = 1; i< index; i++){
             
             if(highestScore < Votes[i].score){
                 
                 highestScore = Votes[i].score;
                 highScoreIndex = i;
             }else if(highestScore==Votes[i].score){
                 if(Votes[i].name.compareTo(Votes[highScoreIndex].name) < 0){
                     highestScore = Votes[i].score;
                     highScoreIndex = i;
                     
                     
                 }else{
                     highestScore = Votes[highScoreIndex].score;
                     
                 }
                  
             }
             
             
         }
        
        System.out.println(Votes[highScoreIndex].name +" "+Votes[highScoreIndex].score);
    }

}