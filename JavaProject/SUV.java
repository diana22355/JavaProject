
import java.io.*;
import java.util.Scanner;

public class SUV 
{
	public static void SUVRent(Customer customer)throws IOException
	{
				
		String [] []  SUVs = {{"1","Nissan", "Rogue", "SJB7412B","210"}, 
				   {"2","BMW", "X5", "SJB7413D","335"},
				   {"3","Volvo", "XC40", "SJB3468E","250"},
				   {"4","GMC", "Terrain", "SJB8211M","100"},{"5","Toyota", "RAV4", "SJC2234P","150"},
				   {"6","Honda", "CR-V", "SJC1134L","180"},{"7","Mazda", "CX-5", "C12Y823W","117"},
				   {"8","Kia", "Soul", "SJB823QA","133"},{"9","Dodge", "Durango", "MMS8234L","210"},
				   {"10","Audi", "Q7", "AAB8234L","125"}};

		
		//Reading values
		   
		File file = new File ("InventorySUVs.txt");
		Scanner inputFile = new Scanner(file);	  
		System.out.println("\nThis are our SUVs models: \n");
		System.out.println("No.\t" + "Maker\t" + "Model\t" + "Serial Number\t" + "Cost/day($)\t");
		int row =0;
		int col=0;
		while ((inputFile.hasNext()) || (row < SUVs.length) && (col <SUVs[row].length))
		 			{
				    String output = inputFile.nextLine();
				    row++; 
				    col++;
				    System.out.print(output + "\n");
		 			}
				  	inputFile.close();
				  
				  char response='0';
				  
				  do
				  {
				  	
		Scanner input = new Scanner(System.in);
		System.out.println(" ");
		System.out.print("Enter the number of car to rent: ");
		String number = input.nextLine();
				  
				  String model="null";
				 double cost=0; 
				  int i=0;
				  int result=0;
				  int rented=0;
				  boolean found=false;
				  String serialNumber="";
				  String book = "";
				  String Content = "";

				  while ((!found) && (i< SUVs.length))
				  		{
					  	if (SUVs[i][0].equals(number))
					  		{
					  		
					 	  BufferedReader reader = new BufferedReader(new FileReader("InventorySUVs.txt"));
					 	  String line = reader.readLine();
			        	 result=1;
				         found=true;
				         cost = Double.parseDouble((SUVs[i][4]));
				         model = SUVs[i][2];
				         serialNumber=SUVs[i][3];
				         book = "\"BOOKED\""+ (SUVs[i][0]);
				         	while (line != null) 
				         		{
		 	                	Content = Content + line + System.lineSeparator();
		 	                	line = reader.readLine();
				         		}
				         		if (Content.contains(book))
				         			{
				         			rented=1;
				         			reader.close();
				         			}
				         		
					  		}
					  	
					  	else
					  		{
					  		i++;
					  		}
			  
				  		}
				  
				  
				 
				  if (rented==1)
				  {
					  System.out.println("******************************************************************************\n");
				  		System.out.println("\t\tSorry, the car is already booked\n");
				  		System.out.println("******************************************************************************\n");
				  }
	
				  else if (result ==1)
					 		{
					  	System.out.println("******************************************************************************\n");
					  	System.out.println("\t\t\"The model is available\"\n");
					  	System.out.println("******************************************************************************\n");
					  	
					  	System.out.println("\nEnter number of days: ");
					  	int days = input.nextInt();
					 
					  	double grossPay = days * cost;
					 
					  	System.out.println(" ");
					  	System.out.println("Model\t"+  "DailyRate\t"+  "Duration\t"+  "TotalCost\t");
					  	System.out.printf("%s\t$%s\t\t%d days\t\t$%,.2f\n",model, cost, days, grossPay);
					 
					  				
					  		input.nextLine();
					  		
					  		System.out.println("\nWould you like to proceed to rent?( y/n ): ");
					  	
					  		String answer = input.nextLine();
					  		
					  			{
					  					if (answer.equals("y")|| answer.equals("Y")) 
					  						{
					  						System.out.println("\n\nHow would you like to pay? Choose 1 by card and 2 by cash");
				  							int payment = input.nextInt();
				  							Payment.PaymentMethod(payment, customer, days, grossPay);
				  							
				  							int x=0;
				  							boolean car = false;
				  							while ((!car) && (x< SUVs.length))
				  							{
				  								if (SUVs[x][0].equals(number))
				  									{      
				  										SUVs[x][3]="\"BOOKED\""+ (SUVs[x][0]);
				  										car=true;
				  									}
				  								else
				  									{
				  									x++;
				  									}
				  							}
				  							
				 	
				  						PrintWriter InventoryRent =  new PrintWriter ("InventorySUVs.txt");
					   
					   
				  						for (int l = 0; l < SUVs.length; l++)
				  								{
				  							InventoryRent.println(" ");
				  							for (int m =0 ; m < SUVs[l].length ; m++)	
				  							InventoryRent.print(SUVs[l][m]+"\t");
				  								}
				  							InventoryRent.close();
	
					  						}
					  					else 
					  						{
					  							
					  							JavaProject.Menu(customer);
					  						}
					  				
					  			}
					  			

					  		}//RESULT=1
				  			
				  		else 
				  			{
		  			System.out.println("******************************************************************************");
		  			System.out.println("\n\t\t\tSorry, the value is not valid");
		  			System.out.println("******************************************************************************");
				  			}
				  
				  	
				  	
					System.out.println("\nWould you like to rent another car?( y/n ): ");
					Scanner option = new Scanner(System.in);
				 	String answerContinue = option.nextLine();
				 	response = answerContinue.charAt(0);
				 							 	
	}
		while (response =='y' || response == 'Y');
		System.out.println("\t\tThank you for renting with us");
		
			  		
}//public

public static void SUVReturn(Customer customer)throws IOException
{
		//Reading values
		   
		String [] []  SUVs = {{"1","Nissan", "Rogue", "SJB7412B","210"}, 
				   {"2","BMW", "X5", "SJB7413D","335"},
				   {"3","Volvo", "XC40", "SJB3468E","250"},
				   {"4","GMC", "Terrain", "SJB8211M","100"},{"5","Toyota", "RAV4", "SJC2234P","150"},
				   {"6","Honda", "CR-V", "SJC1134L","180"},{"7","Mazda", "CX-5", "C12Y823W","117"},
				   {"8","Kia", "Soul", "SJB823QA","133"},{"9","Dodge", "Durango", "MMS8234L","210"},
				   {"10","Audi", "Q7", "AAB8234L","125"}};
		   
		
		
		File file = new File ("InventorySUVs.txt");
			  Scanner inputFile = new Scanner(file);
			 
			  System.out.println("\nThis are our SUVs models: \n");
			  System.out.println("No.\t" + "Maker\t" + "Model\t" + "Serial Number\t" + "Cost/day\t");
			  int row =0;
			  int col=0;
			  while ((inputFile.hasNext()) || (row < SUVs.length) && (col <SUVs[row].length))
			  {
			    String output = inputFile.nextLine();
			    row++; 
			    col++;
			    System.out.print(output + "\n");
			  }
			  inputFile.close();
			  
			  
				  
			  Scanner input = new Scanner(System.in);
			  System.out.println("\nWhat number of car would you like to return?");
			  String car = input.nextLine();
			  System.out.println();
			  boolean found = false;
			  String newContent="";
			  int i=0;
			  int result =0;
			  
			  while ((!found) && (i< SUVs.length))
			  {
		         if (SUVs[i][0].equals(car))
		         		{
		        	 String value = "\"BOOKED\""+ (SUVs[i][0]);
		        	 String oldData = "";
			 	     BufferedReader reader = new BufferedReader(new FileReader("InventorySUVs.txt"));
			 	     String line = reader.readLine();
			 	     found=true;      
			 	            while (line != null) 
			 	            		{
			 	            	oldData = oldData + line + System.lineSeparator();
			 	                 
			 	                	line = reader.readLine();
			 	                
			 	            		}
			 	            	
			 	            		if (oldData.contains(value))
			 	            			{
			 	            		String oldString = "\"BOOKED\""+ (SUVs[i][0]);
			 	            		newContent = oldData.replaceAll(oldString, (SUVs[i][3]));
			 	            		result =1;
			 	            		reader.close();
			 	            			}
			 	            			
			 	            	
			 	            	
			 	            }
		         
		         			
		         else
		         	{
		        	 i++;
		         	}
		  
			  }
			  
			  
			  if (result == 1 )
			  {
				  FileWriter writer = new FileWriter("InventorySUVs.txt"); 
	 	            writer.write(newContent);
	 	            writer.close();
	 	           
	 	            System.out.println("******************************************************************************");
		          	System.out.println("\t\tModel " + "\""+ SUVs[i][2]+ "\" has been returned successfully! \n");
		          	System.out.println("Model\t\tCustomer Name\t\tPhone Number\t\tLicense Number");
		          	System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t\n\n",SUVs[i][2],customer.sendName(), customer.getPhone(), customer.getLicenseNumber());
		          	System.out.printf("\n\t\tThe return confirmation email has been sent to %s successfully!\n\n", customer.getEmail());
		          	System.out.println("\n\t\t\tThank you for visiting us!\n");
		          	System.out.println("******************************************************************************");
					 

			  }
			  else
			  {
				  System.out.println("******************************************************************************\n");
				  System.out.printf("\t\tSorry the car is not booked\n", customer.sendName());
				  System.out.println("******************************************************************************");
			  }
			  
			  
			  char response = '0';
			  	Scanner output = new Scanner (System.in);
				 System.out.println("\nWould you like to return another car?( y/n ): ");
				 String answerContinue = output.nextLine();
				 response = answerContinue.charAt(0);
			   
				 if (response=='n' || response == 'N')
				 	{
					 System.out.println("******************************************************************************\n");
					 System.out.println("\t\tThank you for renting with us! \n");
					 System.out.println("******************************************************************************\n");
				 	}
				 
				 else if (response =='y' || response == 'Y')
				 {
					 JavaProject.returnCar(customer);
				 }
				 
				 
			  

	}

			
	
	
}
