//Lab05v110.java
//Student version of the Lab05 assignment

import java.awt.*;
import java.applet.*;

public class Lab05v110 extends Applet
{
   public void paint(Graphics g)
   {
      int width = 980;
      int height = 630;
      g.drawRect(10,10,width,height);

//right bottom corner       
      int startYrb = 640;
      int startXrb = 10;
      int endYrb = 630;
      int endXrb = 990;
      int lines = 0;
 
      for (lines = 1; lines <= 70;lines ++)
      {
         g.drawLine(startXrb,startYrb,endXrb,endYrb);
         startXrb = startXrb + 14;
         endYrb = endYrb - 9;
      } 
//left bottom corner
      lines = 0;
      int startXlb = 990;
      int startYlb = 640;
      int endXlb = 10;
      int endYlb = 630;
      for (lines = 1; lines <= 70; lines ++)
      {
         g.drawLine(startXlb,startYlb,endXlb,endYlb);
         startXlb = startXlb - 14;
         endYlb = endYlb - 9;
      } 
//top left corner
      lines = 0;
      int startXtl = 10;
      int startYtl = 10;
      int endXtl = 990;
      int endYtl = 20;
      for (lines = 1; lines <= 70; lines ++)
      {
         g.drawLine(startXtl,startYtl,endXtl,endYtl);
         startXtl = startXtl + 14;
         endYtl = endYtl + 9;
      } 
      
//top right corner
      lines = 0;
      int startXtr = 990;
      int startYtr = 10;
      int endXtr = 10;
      int endYtr = 20;
      for (lines = 1; lines <= 70; lines ++)
      {
         g.drawLine(startXtr,startYtr,endXtr,endYtr);
         startXtr = startXtr - 14;
         endYtr = endYtr + 9;
      } 
     
     
//inner shape!!!    
 g.drawRect(245,158,490,315);



//left bottom corner
     //  lines = 0;
//       int startXlb = 990;
//       int startYlb = 640;
//       int endXlb = 10;
//       int endYlb = 630;
//       for (lines = 1; lines <= 70; lines ++)
//       {
//          g.drawLine(startXlb,startYlb,endXlb,endYlb);
//          startXlb = startXlb - 14;
//          endYlb = endYlb - 9;
//       } 
// //top left corner
//       lines = 0;
//       int startXtl = 10;
//       int startYtl = 10;
//       int endXtl = 990;
//       int endYtl = 20;
//       for (lines = 1; lines <= 70; lines ++)
//       {
//          g.drawLine(startXtl,startYtl,endXtl,endYtl);
//          startXtl = startXtl + 14;
//          endYtl = endYtl + 9;
//       } 
//       
// //top right corner
//       lines = 0;
//       int startXtr = 990;
//       int startYtr = 10;
//       int endXtr = 10;
//       int endYtr = 20;
//       for (lines = 1; lines <= 70; lines ++)
//       {
//          g.drawLine(startXtr,startYtr,endXtr,endYtr);
//          startXtr = startXtr - 14;
//          endYtr = endYtr + 9;
//       } 
//      
    

 
   }



}