import java.awt.*;
import java.applet.*;
import java.util.*; 
import java.util.Random;

public class Enviornment extends Applet
{
   public void paint(Graphics g)
   {
      
      Background.drawBackground(g);   
      Snowflake.drawSnowflake(g);
      Snowman.drawBody(g);
      Snowman.drawArms(g);
      Snowman.drawFace(g);
      Snowman.drawHat(g);
      Tree.drawTrunk(g);
      Tree.drawLeaves(g);
      Tree.drawBulbs(g);
      NorthPole.drawBase(g);
      NorthPole.drawStripes(g);
      NorthPole.drawSign(g);
   }
  




}