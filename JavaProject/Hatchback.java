import java.io.*;
import java.util.Scanner;

public class Hatchback 
{
	public static void HatchbackRent(Customer customer)throws IOException
	{
					
					String [] []  Hatch = {{"1","Honda", "Fit", "PPB7412B","55.50"}, 
							   {"2","Seat", "Ibiza", "MWB7417D","63.25"},
							   {"3","Nissan", "Leaf", "1QB3468L","49.99"},
							   {"4","Kia", "Rio", "XSD8211M","53.00"},{"5","Audi", "A1", "AAA2234P","60.00"},
							   {"6","Toyota", "Prius", "SOO1134L","64.99"},{"7","Ford", "Focus", "KJHY823W","45.00"},
							   {"8","Subaru", "Impreza", "SJB8219V","39.99"},{"9","Fiat", "500", "MMKK934L","47.99"},
							   {"10","Ford", "Fiesta", "QQB8234L","55.00"}};
				 
		
					//Reading values
					   
					File file = new File ("InventoryHatch.txt");
					Scanner inputFile = new Scanner(file);	  
					System.out.println("\nThis are our Hatch models: \n");
					System.out.println("No.\t" + "Maker\t" + "Model\t" + "Serial Number\t" + "Cost/day($)\t");
					int row =0;
					int col=0;
					while ((inputFile.hasNext()) || (row < Hatch.length) && (col <Hatch[row].length))
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
							  boolean found=false;
							  String serialNumber="";
							  String book = "";
							  String Content ="";
							  int rented=0;
									  
							  while ((!found) && (i< Hatch.length))
							  		{
								  	if (Hatch[i][0].equals(number))
							  			{
							  		
								  			BufferedReader reader = new BufferedReader(new FileReader("InventoryHatch.txt"));
								  			String line = reader.readLine();
								  			result=1;
								  			found=true;
								  			cost = Double.parseDouble((Hatch[i][4]));
								  			model = Hatch[i][2];
								  			serialNumber=Hatch[i][3];
								  			book = "\"BOOKED\""+ (Hatch[i][0]);
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
								  						
								  						System.out.println("How would you like to pay? Choose 1 by card and 2 by cash");
							  							int payment = input.nextInt();
							  							Payment.PaymentMethod(payment, customer, days, grossPay);
							  							
								  							int x=0;
								  							boolean car = false;
								  							while ((!car) && (x< Hatch.length))
								  							{
								  								if (Hatch[x][0].equals(number))
								  									{      
								  										Hatch[x][3]="\"BOOKED\""+ (Hatch[x][0]);
								  										car=true;
								  									}
								  								else
								  									{
								  									x++;
								  									}
								  							}
								  							
								 	
								  						PrintWriter InventoryRent =  new PrintWriter ("InventoryHatch.txt");
									   
									   
								  						for (int l = 0; l < Hatch.length; l++)
								  								{
								  							InventoryRent.println(" ");
								  							for (int m =0 ; m < Hatch[l].length ; m++)	
								  							InventoryRent.print(Hatch[l][m]+"\t");
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
					System.out.println("Thank you for renting with us");
						  		
			}//public
public static void HatchbackReturn(Customer customer)throws IOException
			{
				//Reading values
				   
				String [] []  Hatch = {{"1","Honda", "Fit", "PPB7412B","55.50"}, 
						   {"2","Seat", "Ibiza", "MWB7417D","63.25"},
						   {"3","Nissan", "Leaf", "1QB3468L","49.99"},
						   {"4","Kia", "Rio", "XSD8211M","53.00"},{"5","Audi", "A1", "AAA2234P","60.00"},
						   {"6","Toyota", "Prius", "SOO1134L","64.99"},{"7","Ford", "Focus", "KJHY823W","45.00"},
						   {"8","Subaru", "Impreza", "SJB8219V","39.99"},{"9","Fiat", "500", "MMKK934L","47.99"},
						   {"10","Ford", "Fiesta", "QQB8234L","55.00"}};
				
				File file = new File ("InventoryHatch.txt");
				  Scanner inputFile = new Scanner(file);
				 
				  System.out.println("\nThis are our Hatchback models: \n");
				  System.out.println("No.\t" + "Maker\t" + "Model\t" + "Serial Number\t" + "Cost/day\t");
				  int row =0;
				  int col=0;
				  while ((inputFile.hasNext()) || (row < Hatch.length) && (col <Hatch[row].length))
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
				  
				  while ((!found) && (i< Hatch.length))
				  {
			         if (Hatch[i][0].equals(car))
			         		{
			        	 String value = "\"BOOKED\""+ (Hatch[i][0]);
			        	 String oldData = "";
				 	     BufferedReader reader = new BufferedReader(new FileReader("InventoryHatch.txt"));
				 	     String line = reader.readLine();
				 	     found=true;      
				 	            while (line != null) 
				 	            		{
				 	            	oldData = oldData + line + System.lineSeparator();
				 	                 
				 	                	line = reader.readLine();
				 	                
				 	            		}
				 	            	
				 	            		if (oldData.contains(value))
				 	            			{
				 	            		String oldString = "\"BOOKED\""+ (Hatch[i][0]);
				 	            		newContent = oldData.replaceAll(oldString, (Hatch[i][3]));
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
					  FileWriter writer = new FileWriter("InventoryHatch.txt"); 
		 	            writer.write(newContent);
		 	            writer.close();
		 	           
		 	           System.out.println("******************************************************************************");
			          	System.out.println("\t\tModel " + "\""+ Hatch[i][2]+ "\" has been returned successfully! \n");
			          	System.out.println("Model\t\tCustomer Name\t\tPhone Number\t\tLicense Number");
			          	System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t\n\n",Hatch[i][2],customer.sendName(), customer.getPhone(), customer.getLicenseNumber());
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
