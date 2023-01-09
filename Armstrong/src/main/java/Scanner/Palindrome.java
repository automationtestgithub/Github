package Scanner;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[]args)
	{
		 int number, sum,rem=0;
		    System.out.println("Enter Number");
		    @SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
		    int num=sc.nextInt();
		    number=num;
		    
		    for(sum=0;num>0;num=num/10)
		    {		    	
		    	rem=num%10;
		    	sum=sum*10+rem;
		    }
		    if(sum==number)
		    {
		    	System.out.println("Number is Palindrome");
		    }
		    else
		    {
		    	System.out.println("Number is not Palindrome");
		    }
	}
}