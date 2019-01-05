class RationalB
{
  public int den;
  public int num;

  
  public RationalB(int n,int d)
  {
     den = d;
     num = n;
  
  }
  public RationalB()
  {
      
  }
  
	public void displayData()
	{
		System.out.println();
		System.out.println(getOriginal() + " equals " + getDecimal());
      System.out.println();
      System.out.println("and reduces to " + getReduced());
		System.out.println();
	}
 
     
   public String getReduced()
   {
     
      int gcf = getGCF(num,den);
      
      int newNum = num/gcf;
      int newDen = den/gcf;
      String snum = String.valueOf(newNum);
      String sden = String.valueOf(newDen);
      String reduced = newNum + "/" + newDen;
      
      return reduced;
   }
   
  
   public void multiply(RationalB r1,RationalB r2)
   {
      int den = r1.getDen();
      int num = r1.getNum();
      int den2 = r2.getDen();
      int num2 = r2.getNum();
      
      den = den*den2;
      num = num*num2;
      this.setDen(den);
      this.setNum(num);
     
   }
   public void add(RationalB r1,RationalB r2)
   {
      int den = r1.getDen();
      int num = r1.getNum();
      int den2 = r2.getDen();
      int num2 = r2.getNum();
      
      int newNum = num*den2;
      int newNum2 = num2 *den;
      
      
      den = den2*den;
      num = newNum+ newNum2;
     
      this.setDen(den);
      this.setNum(num);
     
   }
   public void subtract(RationalB r1,RationalB r2)
   {
      int den = r1.getDen();
      int num = r1.getNum();
      int den2 = r2.getDen();
      int num2 = r2.getNum();
      
      int newNum = num*den2;
      int newNum2 = num2 *den;
      
      
      den = den2*den;
      num = newNum- newNum2;
     
      this.setDen(den);
      this.setNum(num);
     
   }


   public void divide(RationalB r1, RationalB r2)
   {
      int den = r1.getDen();
      int num = r1.getNum();
      int den2 = r2.getDen();
      int num2 = r2.getNum();

      
      den = den*num2;
      num = num*den2;
      this.setDen(den);
      this.setNum(num);
   
   
        }
        
        
   
   
   public String getOriginal()
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
       if (n == 0)
       {
         n = 1;
       }
       
       return n;
  
   }
  
  
  //getters 
   public int getDen(){return den;}
   
   public void setDen(int d){den = d;}
   
   public void setNum(int n){num = n;}
   
   private float getDecimal(){return (float)num/den;}
   
   public int getNum(){return num;}
   
 
   
   }