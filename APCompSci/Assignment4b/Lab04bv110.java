import java.awt.*; 
import java.applet.*;

public class Lab04bv110 extends Applet

{
    public void paint(Graphics g)
   {
      
 //Cube
      g.drawRect(100,100,200,200);
      g.drawRect(150,150,200,200);
      g.drawLine(100,100,150,150);
      g.drawLine(300,300,350,350);
      g.drawLine(100,300,150,350);
      g.drawLine(300,100,350,150);
      
 //Draw APCS
      //A:
      g.fillRect(100,400,30,10);
      g.fillRect(100,400,10,50);
      g.fillRect(120,400,10,50);
      g.fillRect(110,420,10,10);
       
      //P:
      g.fillRect(140,400,30,10);
      g.fillRect(140,400,10,50);
      g.fillRect(150,420,10,10);
      g.fillRect(160,400,10,30);
      //C:
      g.fillRect(180,400,30,10);
      g.fillRect(180,400,10,40);
      g.fillRect(180,440,30,10);
      //S:
      g.fillRect(220,400,30,10);
      g.fillRect(220,400,10,20);
      g.fillRect(220,420,30,10);
      g.fillRect(240,420,10,20);
      g.fillRect(220,440,30,10);
 //Circle with ovals inside
      //circle
      g.drawOval(125,125,200,200);
      //vertical ovals
      g.drawOval(200,125,50,200);
      g.drawOval(175,125,100,200);
      g.drawOval(150,125,150,200);
      //horizontal ovals
      g.drawOval(125,200,200,50);
      g.drawOval(125,175,200,100);
      g.drawOval(125,150,200,150);
 //arcs in a cirle
      //up
      g.fillArc(400,360,60,60,135,270);
      //left
      g.fillArc(360,400,60,60,225,270);
      //bottom
      g.fillArc(400,440,60,60,315,270);
      //right 
      g.fillArc(440,400,60,60,45,270);
 
 //triangle with circle
      //circle
      g.drawOval(550,350,200,200);
      //triangle
      g.drawLine(550,450,650,550);
      g.drawLine(550,450,725,385);
      g.drawLine(650,550,725,385);
      //second circle
      g.drawOval(590,420,95,95);
    } 
     

 
}