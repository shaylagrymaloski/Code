import java.awt.*;
import java.applet.*;


class Snowman
{
   
   public static void drawBody(Graphics g)
   {
      g.setColor(Color.black);
      g.drawOval(100,100,75,75);
      g.drawOval(90,150,100,100);
      g.drawOval(80,200,125,125);
      
      g.setColor(Color.white);
      g.fillOval(100,100,74,74);
      g.fillOval(90,150,99,99);
      g.fillOval(80,200,124,124);
   }
   public static void drawArms(Graphics g)
   {
      Color myBrown = new Color(139,69,19);
      g.setColor(myBrown);
      g.drawLine(55,160,90,190);
      g.drawLine(215,160,190,190);
   }
   public static void drawFace(Graphics g)
   {
      //eyes
      g.setColor(Color.black);
      g.fillOval(115,115,10,10);
      g.fillOval(145,115,10,10);
      //mouth
      g.fillOval(111,140,7,7);
      g.fillOval(121,145,7,7);
      g.fillOval(131,148, 7,7);
      g.fillOval(141,145,7,7);
      g.fillOval(151,140,7,7);
      
      
      //nose
      g.setColor(Color.orange);
      g.fillPolygon(new int[]{130,130,145}, new int[] {130,140,135},3);
      }
    public static void drawHat(Graphics g)
    {
      g.setColor(Color.black);
      g.fillRect(100,90,75,20);
      g.fillRect(112,70,50,20);
   }
   


}