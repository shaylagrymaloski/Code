import java.awt.*;


class RoofSub extends House
{

   public  int x;
   public  int x2;
   public  int x3;
   public  int y;
   public  int y2;
   public  int y3;
   private Point tallestPoint;
   
   
  

   public  RoofSub(int xpoint, int xpoint2, int xpoint3, int ypoint, int ypoint2, int ypoint3)
   {
      int x = xpoint;
      int x2 = xpoint2;
      int x3 = xpoint3;
      int y = ypoint;
      int y2 = ypoint2;
      int y3 = ypoint3;
      
      
      setX(x);
      setX2(x2);
      setX3(x3);
      setY(y);
      setY2(y2);
      setY3(y3);
      tallestPoint = new Point(188,40);
      
      
    }  
    public RoofSub()
    {
    
    }
  public void drawRoof(Graphics g)
   {
      
      g.setColor(Color.black);
    
      g.fillPolygon(new int[] {x, tallestPoint.getX(), x3}, new int[] {y, tallestPoint.getY(), y3}, 3);
     
   
   
}

   
   public int getX(){return x;}
   public int getX2(){return x2;}
   public int getX3(){return x3;}

   public int getY(){return y;}
   public int getY2(){return y2;}
   public int getY3(){return y3;}
  
   public void setX(int point){ x = point;}
   public void setX2(int point){ x2 = point;}
   public void setX3(int point){ x3 = point;}
   
   public void setY(int point){ y = point;}
   public void setY2(int point){ y2 = point;}
   public void setY3(int point){ y3 = point;}

   
      
   
   
   

}
