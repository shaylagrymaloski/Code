// Lab09v100.java
// The Rationalv100 Class Program I
// This is the student, starting version of the Lab09a assignment.


import java.util.Scanner;


public class Lab09B
{
   private static int num, den;   // numerator and denominator of the 1st rational number
   private static int num2, den2;   // numerator and denominator of the 2nd rational number

   public static void main (String args[])
   {
      enterData();

      RationalB r1 = new RationalB(num,den);
      RationalB r2 = new RationalB(num2,den2);
      RationalB r3 = new RationalB();

      r3.multiply(r1,r2);
      System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
      r3.divide(r1,r2);
      System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());
      r3.add(r1,r2);
      System.out.println("\n\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
      r3.subtract(r1,r2);
      System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
      System.out.println();

}
	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the first numerator ----> ");
		num = input.nextInt();
		System.out.print("\nEnter the first denominator --> ");
		den = input.nextInt();
      System.out.print("\nEnter the second numerator ----> ");
		num2 = input.nextInt();
		System.out.print("\nEnter the second denominator --> ");
		den2 = input.nextInt();
      
	}
}
