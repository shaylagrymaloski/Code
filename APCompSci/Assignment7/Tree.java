import java.awt.*;
import java.applet.*;
import java.util.*; 
import java.util.Random;


class Tree{
  
  public static void drawTrunk(Graphics g)
  {
      Color myTreeBrown = new Color (165,42,42);
      g.setColor(myTreeBrown);
      g.fillRect(400,240,25,50);
  
  }
  public static void drawLeaves(Graphics g)
  {
  
      Color myGreen = new Color (34,139,34);
      g.setColor(myGreen);
      g.fillPolygon(new int[]{300,412,525}, new int[] {240, 115, 240},3);
      g.fillPolygon(new int[]{325,412,500}, new int[] {190, 65,190},3);
      g.fillPolygon(new int[]{350,412,475}, new int[] {140,15,140},3);
  
  }
  public static void drawBulbs(Graphics g)
  {
      Color myRed = new Color (150,10,10);
      g.setColor(myRed);
      g.fillOval(375,200,10,10);
      g.fillOval(450,150,10,10);
      g.fillOval(400,100,10,10);
      g.fillOval(360,125, 10,10);
      g.fillOval(475,225,10,10);
      g.fillOval(415,75,10,10);
      g.fillOval(350,230, 10,10);
      g.fillOval(390,160,10,10);
      g.fillOval(425,190,10,10);
     
     
      
  
  }


}