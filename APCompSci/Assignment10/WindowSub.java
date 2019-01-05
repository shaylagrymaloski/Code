import java.awt.*;

class WindowSub extends House
{
   
   public  int x;
   public  int y;
   public int h;
   public int w;
 
  

   public  WindowSub(int xpoint, int ypoint, int width, int height)
   {
      int x = xpoint;
      int y = ypoint;
      int w = width;
      int h = height;
      setX(x);
      setY(y);
      setW(w);
      setH(h);
      
      
      
           

    }  
    public WindowSub()
    {
     System.out.println();
    }
  public void drawWindow(Graphics g)
   {
      
    //  Color myBlack = new Color(162, 42, 42);
   
      g.setColor(Color.black);
      g.drawRect(x,y,w,h);
      int verticalX = x +13;
      int verticalY = y+25;
      int horizontalY = y+13;
      int horizontalX = x + 25;
      PannelsSub p1 = new PannelsSub(verticalX,y,verticalX,verticalY);
      PannelsSub p2 = new PannelsSub(x,horizontalY,horizontalX,horizontalY);

      p1.drawPannels(g);
      p2.drawPannels(g);

      
   
   
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