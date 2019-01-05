import java.awt.*;

class PannelsSub extends WindowSub
{


   public  int x;
   public  int y;
   public int x2;
   public int y2;
   
   
   
   public  PannelsSub(int xpoint, int ypoint, int x2point, int y2point)
   {
      int x = xpoint;
      int y = ypoint;
      int x2 = x2point;
      int y2 = y2point;
      setX(x);
      setY(y);
      setX2(x2);
      setY2(y2);
      
    }  
    public PannelsSub()
    {
    
    }
 
   
   public void drawPannels(Graphics g)
   {
    
      g.setColor(Color.black);
      g.drawLine(x,y,x2,y2);
      
   
   
}

   
   public int getX(){return x;}
   public int getY(){return y;}
   public int getX2(){return x2;}
   public int getY2(){return y2;}
   public void setX(int point){ x = point;}
   public void setY(int point){ y = point;}
   public void setX2(int point){ x2 = point;}
   public void setY2(int point){ y2 = point;}


}