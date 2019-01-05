public class Lab03v100
{
   public static void main(String[] args)

   {
      
      int startMSec = 10000123;
      int hours = startMSec/3600000;
      int remainingMS = startMSec%3600000;
      int min = remainingMS/60000;
      int remainingS = remainingMS%60000;
      int sec = remainingS/1000;
      
      int MSec = remainingMS%1000;
      
      
      System.out.println("Starting seconds: "+ startMSec);
      System.out.println("Hours: "+ hours);
      System.out.println("Minutes: "+ min);
      System.out.println("Seconds: "+ sec);
      System.out.println("Miliseconds: "+ MSec); 
      

   }  




}