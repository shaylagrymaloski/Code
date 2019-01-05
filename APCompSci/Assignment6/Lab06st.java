// Lab06st.java
// Shayla Grymaloski

import java.awt.*;
import java.applet.*;
import java.util.*; 
import java.util.Random;

																
public class Lab06st extends Applet
{
	public void paint(Graphics g) 	
	{
      Color myRed = new Color(255,0,64);  
      Color myGreen = new Color(16,255,16);  
      Color myBlue = new Color(64,64,255); 
      Color myYellow = new Color(200,200,0);   
// Draw Grid
		g.drawRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);

// Draw Random Lines
		Random randomInt = new Random(12345); 
      for (int k = 1; k <= 100; k++)
      {
         int x1 = randomInt.nextInt(390)+10; 
         int y1 = randomInt.nextInt(290)+10; 
         int x2 = randomInt.nextInt(390)+10;
         int y2 = randomInt.nextInt(290)+10;
         int red = randomInt.nextInt(255);
         int green = randomInt.nextInt(255);
         int blue = randomInt.nextInt(255); 
         g.setColor(new Color(red,green,blue)); 
         g.drawLine(x1,y1,x2,y2);
      }
      
// Draw Random Squares
		Random rndInt = new Random(); 
      for (int k = 1; k <= 100; k++)
      {
         int x = rndInt.nextInt(340)+400;
         int y = rndInt.nextInt(240)+10;
         int red = rndInt.nextInt(256);
         int green = rndInt.nextInt(256);
         int blue = rndInt.nextInt(256);
         g.setColor(new Color(red,green,blue)); 
         g.fillRect(x,y,50,50);
}		
// Draw Random Circles
			
          for (int count = 1; count <= 100; count++)
     {
         int red = (int) (Math.random() * 256);
         int green = (int) (Math.random() * 256);
         int blue = (int) (Math.random() * 256);
         int diameter = (int) (Math.random() * 200);
         g.setColor(new Color(red,green,blue));
         int x = (int) (Math.random() * (390-diameter) + 10);
         int y = (int) (Math.random() * (290-diameter) + 300);
         g.drawOval(x,y,diameter,diameter);
      }
	
// Draw 3-D Box
   //Blue
      g.setColor(myBlue);
      int [ ] x2 = {635, 685, 685, 636, 635, 685};
      int [ ] y2 = {395, 425, 525, 495, 395,425};
      g.fillPolygon(x2, y2, 6);   
   //Yellow
      g.setColor(myYellow);
      g.fillRect(535,395,100,100);
   //Green
      g.setColor(myGreen);
      int [ ] x = {535, 585, 585, 536, 535, 585};
      int [ ] y = {395, 425, 525, 495, 395,425};
      g.fillPolygon(x, y, 6);
   //Red
      g.setColor(myRed);
      g.fillRect(585,425,100,100);
  
	}	
}  
