import java.awt.*;

class DoorSub extends House
{
   public  int x;
   public  int y;
   public int h;
   public int w;
   private Point start;
  

   public  DoorSub(int xpoint, int ypoint, int width, int height)
   {
      int x = xpoint;
      int y = ypoint;
      int w = width;
      int h = height;
      setX(x);
      setY(y);
      setW(w);
      setH(h);
      start = new Point(175,275);
      
    }  
    public DoorSub()
    {
    
    }
  public void drawDoor(Graphics g)
   {
      
      g.setColor(Color.black);
      g.drawRect(start.getX(),start.getY(),w,h);
      
   
   
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