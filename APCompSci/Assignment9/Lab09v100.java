// Lab09v100.java
// The Rationalv100 Class Program I
// This is the student, starting version of the Lab09a assignment.


import java.util.Scanner;


public class Lab09v100
{
	private static int num, den;   // numerator and denominator of the rational number

	public static void main (String[] args)
	{
		enterData();
		Rationalv100 r = new Rationalv100(den, num);
 		r.displayData();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the numerator ----> ");
		num = input.nextInt();
		System.out.print("\nEnter the denominator --> ");
		den = input.nextInt();
	}
}
