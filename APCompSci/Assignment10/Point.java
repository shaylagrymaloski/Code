public class Point
{
   private int x;
   private int y;
   private int x2;
   
   public Point()
   {
      x = 0;
      y = 0;
      x2 = 0;
   }
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
      x2 = x +75;
     
   }
      
   public int getX() { return x; }
   public int getY() { return y; }
   public int getX2(){return x2;}
  
   
   public void setX(int x) { this.x = x; }
   public void setY(int y) { this.y = y; }
   public void setX2(int x2){this.x2 = x2;}
  
}
