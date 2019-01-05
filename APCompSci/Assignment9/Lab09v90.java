// Lab09v90.java
// The Rationalv90 Class Program I
// This is the student, starting version of the Lab09a assignment.

import java.util.Scanner;


public class Lab09v90
{
	private static int num, den;   // numerator and denominator of the rational number

	public static void main (String[] args)
	{
		enterData();
		Rationalv90 r = new Rationalv90(den, num);
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

