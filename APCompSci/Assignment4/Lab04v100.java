// Lab04av100.java
// The Mortgage Payment Program
// This the completed 90 point version of the Lab04a assignment.
// This version computes the Mortgage Payment, Total Payments, and Total Interest.


public class Lab04v100
{

  

	public static void main(String args[])
	{
		System.out.println("Lab04a, 100 Point Version\n");

		double principal  = 250000;
		double annualRate = 4.85;
		double numYears   = 30;

		double monthlyRate = annualRate / 1200;
		double numMonths = numYears * 12;

		double temp = Math.pow(1 + monthlyRate, numMonths);
		double monthlyPayment = ((monthlyRate * temp) / (temp - 1)) * principal;

		double totalPayments = monthlyPayment * numMonths;
		double totalInterest = totalPayments  - principal;
      
      
		System.out.println();
		System.out.println("Principal:        $" + Math.round(principal*100)/100D);
		System.out.println("Annual Rate:      " + Math.round(annualRate*100)/100D + "%");
		System.out.println("Number of Years:  " + Math.round(numYears*100)/100D);
		System.out.println("Monthly Payment:  $" + Math.round(monthlyPayment*100)/100D);
		System.out.println("Total Payments:   $" + Math.round(totalPayments*100)/100D);
		System.out.println("Total Interest:   $" + Math.round(totalInterest*100)/100D);
		System.out.println();
	}
   
    
}