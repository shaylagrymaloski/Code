// Lab04av80.java
// The Mortgage Payment Program



public class Lab04av80
{
	public static void main(String[] args)
	{
		System.out.println("Lab04a, 80 Point Version\n");

		double principal  = 250000;
		double annualRate = 4.85;
		double numYears   = 30;

		double monthlyRate = annualRate / 1200;
		double numMonths = numYears * 12;

		double temp = Math.pow(1 + monthlyRate, numMonths);
      
		double monthlyPayment = ((monthlyRate * temp) / (temp - 1)) * principal;

		System.out.println();
		System.out.println("Principal:        $" + principal);
		System.out.println("Annual Rate:      " + annualRate + "%");
		System.out.println("Number of Years:  " + numYears);
		System.out.println("Monthly Payment:  $" + monthlyPayment);
		System.out.println();
	}
}
