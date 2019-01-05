import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Deck 
{
	private Card[] cards;
   private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
   private String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine",
                             "Ten","Jack","Queen","King","Ace"};
   private int[] pointValues = {2,3,4,5,6,7,8,9,10,10,10,10,11};
   
	private int size;

	public Deck() 
   {
      size = 52;
		cards = new Card[size];
      int count = 0;
      Random radCount = new Random(100);
      boolean[] radSpot = new boolean[52];
      
      for (int suitIndex = 0; suitIndex < 4; suitIndex++)
      {
        
        
         
         for (int rankIndex = 0; rankIndex < 13; rankIndex++)
          {  
          
 //START OF 100 POINT VERION
          int x = 0;
          while(x == 0)
          {
              int radNum =radCount.nextInt(52);
           
             if (radSpot[radNum] == false)
             {
                 count = radNum; 
                 radSpot[radNum] = true; 
                 x = 1;  
             }
            
             
          } 
          
   // END OF 100 POINT VERION     
       
          cards[count] = new Card(suits[suitIndex],ranks[rankIndex],pointValues[rankIndex]);
           
          
         }
      }
      
      //90 POINT VERSION!
      
     // shuffle();
	}
   
 //90 POINT SHUFFLE VERSION BELLOW!
   
//   public void shuffle()
// {
//   Random randomInt = new Random(100);
//    for(int i = 0; i<1000; i++)
//    {
//        
//     
//        
//        int firstCard = randomInt.nextInt(52);
//        int secondCard = randomInt.nextInt(52);
//      
//       
//       
//       Card sC = cards[secondCard];
//       
//       Card fC = cards[firstCard];
//       
//       cards[firstCard] = sC;
//       cards[secondCard] = fC;
//    }    

//}


   
     public String toString()
   {
      String temp = "";
      for (int k = 0; k < size; k++)
         temp = temp + cards[k].toString() + "\n";
      return temp;   
}

}

