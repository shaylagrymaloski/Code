import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Lab12b
{
	public static void main(String[] args)
	{
		MagpieLab12b maggie = new MagpieLab12b();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}
}


