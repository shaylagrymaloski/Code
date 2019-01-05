class Rationalv100
{
  public int den;
  public int num;
  
  public Rationalv100(int d,int n)
  {
     den = d;
     num = n;
  
  }
  
	public void displayData()
	{
		System.out.println();
		System.out.println(getOriginal() + " equals " + getDecimal());
      System.out.println();
      System.out.println("and reduces to " + getReduced());
		System.out.println();
	}
   public int getDen()
   {
      return den;    
   }
   private float getDecimal()
   {
     return (float)num/den;
   }
   private int getNum()
   {
     return num;
   }
     
   private String getReduced()
   {
      int n = getGCF(num,den);
      
      int gcf = n;
      int newNum = num/gcf;
      int newDen = den/gcf;
      String snum = String.valueOf(newNum);
      String sden = String.valueOf(newDen);
      String reduced = newNum + "/" + newDen;
      
      return reduced;
   }
   
   private String getOriginal()
   {
      String snum = String.valueOf(num);
      String sden = String.valueOf(den);
      String original = snum+"/"+sden;
      return original;
   }
   
	 private int getGCF(int n,int d)
	{
 		 while(n!=0 && d!=0) 
       {
      int x = d;
      d = n%d;
      n = x;
       }
       return n;
  
   }
   }