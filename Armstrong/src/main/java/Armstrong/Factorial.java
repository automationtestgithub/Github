package Armstrong;

public class Factorial {

	public static void main(String[] args) 
	{
		int fact = 1;
		int no = 6;
		for(int i=1;i<=no;i++)
		{
			fact = fact*i;
		}
		System.out.println("Factorial No is: " +fact);
	}
}