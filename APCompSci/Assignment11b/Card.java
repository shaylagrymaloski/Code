

public class Card
{
   private String suit;
   private String rank;
   private int pointValue;

   public Card(String s, String r, int pV)
   {
      suit = s;
      rank = r;
      pointValue = pV;
   }

   public String getSuit()             { return suit; }
   public String getRank()             { return rank; }
   public int getPointValue()          { return pointValue; }
   
   public void setSuit(String s)       { suit = s; }
   public void setRank(String r)       { rank = r; }
   public void setPointValue(int pV)   { pointValue = pV; }
   
   public String toString()
   {
      return "[" + suit + ", " + rank + ", " + pointValue + "]";
   }

}
