import java.awt.*;
import java.applet.*;
import java.util.*; 
import java.util.Random;

class Snowflake
{
   public static void drawSnowflake(Graphics g)
   {
   
      g.setColor(Color.black);
      //draws snowflakes at random points 
      Random randomInt = new Random(12345); 
      for (int k = 1; k <= 45; k++)
      {
         int x = randomInt.nextInt(680); 
         int y = randomInt.nextInt(380); 
         g.drawLine(x, y,x+20,y+20);
         g.drawLine(x+10,y,x+10,y+20);
         g.drawLine(x+20, y, x, y+20);
         g.drawLine(x, y+10, x+20, y+10); 
      }

}
}
