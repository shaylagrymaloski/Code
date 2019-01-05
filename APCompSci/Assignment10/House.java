import java.awt.*;

class House
{

   public  int x;
   public  int y;
   public int w;
   public int h;
   private Point start;
   
   
   public  House(int xpoint, int ypoint, int width, int height)
   {
      int x = xpoint;
      int y = ypoint;
      int w = width;
      int h = height;
      setX(x);
      setY(y);
      setW(w);
      setH(h);
      start = new Point(100,150);
      
      
    }  
    public House()
    {
     
      
    }
 
   
   public void drawHouse(Graphics g)
   {
   
  
    Color myBrown = new Color(162, 42, 42);

      g.setColor(myBrown);
      g.fillRect(start.getX(),start.getY(),w,h);
      g.setColor(Color.black);
      g.drawRect(start.getX(),start.getY(),w,h);
      
      
     
      WindowSub w1 = new WindowSub(125,200,25,25);
      WindowSub w2 = new WindowSub(225,200,25,25);
      w1.drawWindow(g);
      w2.drawWindow(g);
      
      Point pd1 = new Point(0,0);
      DoorSub d1 = new DoorSub(0,0,25,50);
      d1.drawDoor(g);
      
      
      
      RoofSub r1 = new RoofSub(75,0,300,150,0,150);
      r1.drawRoof(g);
      
   
   
}

   
   public int getX(){return x;}
   public int getY(){return y;}
   public int getW(){return w;}
   public int getH(){return h;}
   public void setX(int point){ x = point;}
   public void setY(int point){ y = point;}
   public void setW(int point){ w = point;}
   public void setH(int point){ h = point;}

 
}