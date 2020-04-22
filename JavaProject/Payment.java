import java.util.Random;
import java.util.Scanner;

public class Payment 
{
	public static void PaymentMethod(int option, Customer customer, int days, double cost)
	{
		int method = option;
		
		
		switch(method)
		{
		case(1):
		{
			CardMethod(customer, days, cost);
		}
		break;
		case(2):
		{
			CashMethod(customer, days, cost);
		}
		break;
		default:
		{
			System.out.println("*******************************************************");
			System.out.println("\t\tSorry, the option is not valid");
			System.out.println("*******************************************************");
		}
		break;
		}
	}
			
	public static void CardMethod(Customer customer, int days, double cost)
	{
		String card;
		Scanner input = new Scanner(System.in);
		System.out.println("***************************************************************************************************************");
		System.out.printf("The total balace for %s is $%,.2f: \n\n", customer.sendName(), cost);
		System.out.println("***************************************************************************************************************\n\n");
		System.out.println("Please enter card number to proceed with the payment: (Must be 16 digits long and only contain digits)");
		card = input.nextLine();
		
		int length = card.length();
		if (length==16)	
			{
			int i=0;
			int result =0;
			while (i<16)
					{
						if (Character.isDigit(card.charAt(i)))
						{
							i++;
							result++;
						}
						else
							i++;
					}
				
				if (result==16)	
					{
	
			
			System.out.println("***************************************************************************************************************");
			System.out.printf("\t\tThe car has been booked for %s with license number %s for "+days+" days successfully!\n", customer.sendName(), customer.getLicenseNumber());
			System.out.println("\t\tPhone number registered is: "+ customer.getPhone()+("\n\n"));
			System.out.println("The receipt number is :");
		
			
			Random rand = new Random();
			int receipt;
			
			for (int c=0; c<11 ; c++)
			{
				
				receipt = rand.nextInt(10);
				
				System.out.printf("%d",receipt);
			
			}
			System.out.println("\n");
			System.out.printf("\n\t\tThe receipt has been sent to %s successfully!\n\n", customer.getEmail());
			System.out.println("***************************************************************************************************************");
			
		}
				else
				{
					System.out.println("**************************************************************************");
					System.out.println("\t\tSorry, the option is not valid, only digits are allowed");
					System.out.println("**************************************************************************\n\n");
					CardMethod(customer, days, cost);
				}
				
			}
		else
		{
		System.out.println("****************************************************************************************");
		System.out.println("\t\tSorry, the option is not valid, card number must have 16 digits");
		System.out.println("****************************************************************************************\n\n");
		CardMethod(customer, days, cost);
		}
		
	}
	
	
	public static void CashMethod(Customer customer, int days, double cost)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("***************************************************************************************************************");
		System.out.printf("\t\tThe total balace for %s is $%,.2f:\n\n", customer.sendName(), cost);
		
		System.out.printf("\t\tThe car has been booked for %s with license number %s for "+days+" days successfully!\n", customer.sendName(), customer.getLicenseNumber());
		System.out.println("\t\tPhone number registered is: "+ customer.getPhone()+("\n\n"));
		System.out.println("The receipt number to pay is :");
		
		Random rand = new Random();
		int receipt;
		
		for (int c=0; c<11 ; c++)
		{
			receipt = rand.nextInt(10);
			
			System.out.printf("%d",receipt);
		
		}
		System.out.println("\n");
		System.out.printf("\n\t\tThe receipt has been sent to %s successfully!\n\n", customer.getEmail());
		System.out.println("***************************************************************************************************************\n\n");
		
		
	}
}
