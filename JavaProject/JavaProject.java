
import java.io.*;
import java.util.*;

public class JavaProject 
{
	public static void main(String[] args) throws IOException
	{
		CustomerInformation();
		
	}
	public static void CustomerInformation() throws IOException
		{
	String validLicense1 = "G2";
	String validLicense2= "G";
	String phone;
	String email;
	String license;
	String licenseNumber;
	
	System.out.println("\n\t\tWelcome to Easy Cars!");
	Scanner input = new Scanner (System.in);
	
	
	System.out.println("Please enter customer name ");
	String name = input.nextLine();
	
	System.out.println("Please enter customer email address: ");
	email = input.nextLine();
	
	Customer user = new Customer(name);
	user.setEmail(email);

	
	System.out.println("Please enter customer phone number: (Must be 10 digits long and only contain digits");
	phone = input.nextLine();

	int i =0;
	int result=0;
	if (phone.length() == 10)
	{
		while (i<10)
		{
			if (Character.isDigit(phone.charAt(i)))
				{
				i++;
				result++;
				}
			else
				i++;
		}
			
			if (result==10)
			{
				user.setPhone(phone);
				System.out.println("What type of license does the client have? (G1, G2 or G): ");
				System.out.println("Note: Customers with license type G1 are not allowed to rent a car. ");
				license = input.nextLine();
				
				
				if (license.equalsIgnoreCase(validLicense1))
				{
					System.out.println("Enter license number ");
					licenseNumber = input.nextLine();
					user.setLicenseNumber(licenseNumber);
					Menu(user);
				}
				else if (license.equalsIgnoreCase(validLicense2))
				{
					System.out.println("Enter license number ");
					licenseNumber = input.nextLine();
					user.setLicenseNumber(licenseNumber);
					Menu(user);
				}
				else
					System.out.printf("Sorry %s, we cannot rent a car with that type of license", user.sendName());
				
			}
			else
			{
			System.out.println("*******************************************************************************************");
			System.out.println("\t\tSorry, the option is not valid, Phone number must contain only digits");
			System.out.println("*******************************************************************************************");
			}
	}
		else 
		{
			System.out.println("********************************************************************************************");
			System.out.println("\t\tSorry, the option is not valid, Phone number must have 10 digits");
			System.out.println("********************************************************************************************");
		}

	
		}
public static void Menu(Customer customer)throws IOException
		{
				  Scanner input = new Scanner(System.in);
				  
				   System.out.printf("Hello %s, Would you like to rent or return a car?\n", customer.sendName());
				   System.out.println("\tChoose \"1\" to rent a car, \"2\" to return a car :");
				   int answer=input.nextInt();
				 
				switch (answer)
				{
				case(1):
				{
					carType(customer);
					
				}
					break;
				case(2):
				{
					returnCar(customer);
				}
					break;
				
				default:
				System.out.println("\n\n\n****** Option is not valid ******");
				break;
				
				}
				input.close();
			}
			   
			   
	public static void carType(Customer customer)throws IOException
	{
					
					
					System.out.println("What type of car would you like to rent?\n");
					System.out.println("\tChoose \"1\" to rent a SUV, \"2\" to rent a Sedan or \"3\" to rent a Hatchback:");
					
					Scanner input = new Scanner (System.in);
					int carType =input.nextInt();
					
					switch (carType)
					{
					case(1):
					{
						SUV.SUVRent(customer);
						
					}
						break;
					case(2):
					{
						Sedan.SedanRent(customer);
						
					}
						break;
					case(3):
					{
						Hatchback.HatchbackRent(customer);
					}
						break;
					default:
					System.out.println("\n\n\n****** Option is not valid ******");
					break;
					}
					input.close();
			
			}
public static void returnCar(Customer customer)throws IOException
			{
					
					System.out.println("What type of car would you like to return?\n");
					System.out.println("\tChoose \"1\" to return a SUV, \"2\" to return a Sedan or \"3\" to return a Hatchback:");
					
					Scanner input = new Scanner (System.in);
					
					int returnCar =input.nextInt();
					
					switch (returnCar)
					{
					case(1):
					{
						SUV.SUVReturn(customer);
						
					}
						break;
					case(2):
					{
						Sedan.SedanReturn(customer);
					}
						break;
					case(3):
					{
						Hatchback.HatchbackReturn(customer);
					}
					default:
					System.out.println("\n\n\n****** Option is not valid ******");
					break;
					}
					input.close();
			}



}
