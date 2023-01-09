package Armstrong;

public class Armstrong {
	
	public static void main(String[] args)
	{
		int sum,rem;
		int number = 160;
		int num = number;
		
		for(sum=0;num>0;num=num/10)
		{
			rem = num%10;
			sum = sum+rem*rem*rem;
		}
		if(sum==number)
		{
			System.out.println("Number is Armstrong");
		}
		else
		{
			System.out.println("Number is Not Armstrong");
		}
	}
}