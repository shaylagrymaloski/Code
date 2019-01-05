import java.awt.*;
import java.applet.*;


class Background
{

   
   public static void drawBackground(Graphics g)
   {
      Color mySky = new Color(135,206,250);
      g.setColor(mySky);
      g.fillRect(0,0,700, 200);
      g.setColor(Color.white);
      g.fillRect(0,200,700,200);
   
   }
   

}