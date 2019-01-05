import java.util.ArrayList;
import java.util.Random;


class Deck
{
   private ArrayList<Card> cards;
   private int size;
   private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
   private String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine",
                             "Ten","Jack","Queen","King","Ace"};
   private int[] pointValues = {2,3,4,5,6,7,8,9,10,10,10,10,11};
   
   int count = 0;
   Random radCount = new Random(100);
   boolean[] radSpot = new boolean[52];
   int newSpot;   
   public Deck()
   {
   
      
      
      size= 52;
      cards = new ArrayList<Card>();
      
      for (int i = 0; i <52; i++)
      {
      cards.add(new Card("","",0));
}
      
       for (int suitIndex = 0; suitIndex < 4; suitIndex++)
       {
         for (int rankIndex = 0; rankIndex < 13; rankIndex++)
         {
         
         shuffle100(suitIndex, rankIndex);
    
         //for 90 version:
         //cards.add(new Card(suits[suitIndex],ranks[rankIndex],pointValues[rankIndex]));
         
       
         }
       }
      
     
      // shuffle90();
      //shuffle100();
       //display(); 
       
   
   }
   
 public void shuffle90()
 {
   Random randomInt = new Random(100);
    for(int i = 0; i<1000; i++)
    {

     
        int firstCard = randomInt.nextInt(52);
        int secondCard = randomInt.nextInt(52);
        
         Card sC = cards.get(secondCard);
         Card fC = cards.get(firstCard);
 
       cards.set(firstCard, sC);
       cards.set(secondCard, fC);
       
      
    }    

}
 
public void shuffle100(int suitIndex, int rankIndex)
{
   
  
   int x = 0;
          while(x == 0)
          {
              int radNum =radCount.nextInt(52);
           
             if (radSpot[radNum] == false)
             {
                 count = radNum; 
                 radSpot[radNum] = true; 
                 x = 1;  
                 newSpot = radNum;
                 cards.set(newSpot,new Card(suits[suitIndex],ranks[rankIndex],pointValues[rankIndex]));
             }
            
             
          } 
          

}

       public String toString()
   {
      String temp = "";
      for (int k = 0; k < size; k++)
         temp = temp + cards.get(k).toString() + "\n";
      return temp;   
}
   
      public void display() 
      { 
      for (Card card: cards) 
      System.out.println(card);  
      } 



}