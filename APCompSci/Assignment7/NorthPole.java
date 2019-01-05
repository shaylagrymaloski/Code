import java.awt.*;
import java.applet.*;

class NorthPole
{
   public static void drawBase(Graphics g)
   {

      g.setColor(Color.red);
      g.fillRect(237,250,30,100);
   
  
   }
   public static void drawStripes(Graphics g)
   {
      g.setColor(Color.yellow);
      g.fillRect(237,260,30,10);
      g.fillRect(237,280,30,10);
      g.fillRect(237,300,30,10);
      g.fillRect(237,320,30,10);
      g.fillRect(237,340,30,10);
      
      Color mySilver = new Color(192, 192, 192);
      g.setColor(mySilver);
      g.fillOval(232,215,40,40);
     
   
   }
   public static void drawSign(Graphics g)
   {
      g.setColor(Color.white);
      g.fillRect(220,260,70,30);
      g.setColor(Color.black);
      g.drawRect(220,260,69,29);
      g.drawString("North Pole", 222,277);
   
   }

}