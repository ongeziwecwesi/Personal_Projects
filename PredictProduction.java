package assignment;
import java.util.Random;
import java.util.Scanner;

public class PredictProduction {

	public static void main(String[] args) {
		
			        Scanner input = new Scanner(System.in);
			        Scanner details = new Scanner(System.in);
System.out.println("THIS PROGRAM ESTIMATES THE PRODUCTION OF BULLS AND HEIFERS BASED ON THE NUMBER OF LIVESTOCK OVER THE NUMBER OF YEARS\n"
		+ "INPUTED BY EACH MEMBER DURING REGISTRATION.\n"
		+ "  \n"
		+ "THE ESTIMATED RESULTS ARE BASED ON THESE FACTS:\n"
		+ "• The percentage of cows in heat in a 21-day period = 90%\r\n"
		+ "• The percentage of the heats that are fertile = 90%\r\n"
		+ "• The percentage of the cows that are serviced by the bull = 95%\r\n"
		+ "• The 2 bulls per 100 cows ratio for a period of 5 years(2% of the number of  livestock)\r\n"
		+ "• The percentage of calves born in the herd will be bull = 30%\r\n"
		+ "• The gestation length of a bull valves = 287 days\r\n"
		+ "• The gestation length of a heifer valves = 279 days\r\n"
		+ "• The number of days a cow should undergo involution = 50 days\r\n"
		+ "• The number of births a cow can give in its lifetime = 8 \r\n"
		+ "• The age that a heifer requires to reach puberty and be bred = 14 months(every second year after birth) \n ");


			        //PROMPT THE USER TO REGISTER
			        System.out.println("Enter year of registration: ");
			        int regYear = input.nextInt();

			        System.out.print("Enter number of members to be registered : ");
			        int num_of_members = input.nextInt();

			        System.out.print("Enter how many years of prediction: ");
			        int year = input.nextInt();

			        System.out.println();
			        
			        //Class LiveStockProject instantiated
			        LivestockProject[] registration = new LivestockProject[num_of_members];

			       
			        
			        //member Registration
			        int livestock_Initial = 0;
			        System.out.println("<<<<<<<<<<< MEMBERSHIP REGISTRATION FORM >>>>>>>>>>>>");
			        
			        System.out.println();
			        ///////////////LOOP TILL THE NUMBER OF MEMBERS INPUTED ARE DONE REGISTERING//////////////
			        System.out.println("Registration in progress...");
			           System.out.println();
			           
			        for (int i = 0 ; i < num_of_members; i++){
			            registration[i] = new LivestockProject();


			            ////////////////////APPOINTING MEMBERSHIP NUMBERS////////////////////////////
			            Random membership_num = new Random();
			            int num1 = 0+membership_num.nextInt(9);
			            int num2 = 0+membership_num.nextInt(9);
			            registration[i].setMembership_num(regYear+num1+num2);

			            //////////////// ENTERING DETAILS TO REGISTER //////////////////////////////////
			           
			           
			            System.out.print("Name : ");
			            String name = details.next();
			             registration[i].setName(name);


			             System.out.print("Surname : ");
			             String sName = details.next();
			             registration[i].setSName(sName);


			             System.out.print("Date of Birth (YYYY-MM-DD) : ");
			             String dob = details.next();
			             registration[i].setD_O_B(dob);


			             System.out.print("Gender (male / female / other) : ");
			             String gender = details.next();
			             registration[i].setGender(gender);


			             System.out.print("Location :");
			             String loc = details.next();
			             registration[i].setLoc(loc);


			             System.out.print("Initial number of livestock : ");
			             livestock_Initial = details.nextInt();
			             registration[i].setInitial_Num_of_livestock(livestock_Initial);
			             
			             System.out.println();
			             System.out.println();
			        }
			        
			        System.out.println();
			        System.out.println("<<<<<<<<<<< Registration completed for "+ num_of_members+ " members");
			        System.out.println();
			        
			        /////////////////////////////// REGISTRATION DETAILS CAPTURED //////////////////////////

			        System.out.println();
//////////////////////////PRINTING OUT THE DATABASE WITH THE DETAILS OF THE REGISTERED MEMBERS ////////////////
			        
 System.out.println("<<<<<<<<<<< DATABASE OF REGISTERED MEMBERS >>>>>>>>>>>>");
 for(int i = 0 ; i<num_of_members; i++){
     System.out.println();
     System.out.println("Membership Number           : "  +registration[i].getMembership_num());
     System.out.println("Name                        : "  +registration[i].getName());
     System.out.println("Surname                     : "  +registration[i].getSName());
     System.out.println("Date of Birth               : "  +registration[i].getD_O_B());
     System.out.println("Gender                      : "  +registration[i].getGender());
     System.out.println("Location                    : "  +registration[i].getLoc());
     System.out.println("Initial Number of Livestock : "  +registration[i].getInitial_Num_of_livestock());
     System.out.println();
     System.out.println();
 }
 
 System.out.println();


 ////////////////////////// END OF PRINTING OUT THE DATABASE WITH THE DETAILS OF THE REGISTERED MEMBERS ////////////////





 ////////////////////////// ESTIMATING LIVESTOCK OF MEMBERS ////////////////////
 System.out.println("<<<<<<<<<<<< ESTIMATED LIVESTOCK PRODUCTION OVER "+year+ " YEAR(S) FOR ALL REGISTERED MEMBERS  >>>>>>>>>>>>");
 System.out.println();

 for(int i = 0; i< num_of_members; i++){
     System.out.println(" <<<<<<<<<<< ESTIMATED PRODUCTION FOR MEMBER " +(i+1)+" >>>>>>>>>>> ");
     
     System.out.print((i+1)+ ". "+ registration[i].getName()+" ");
     System.out.print(registration[i].getSName()+" ");
     System.out.println(registration[i].getMembership_num()+" ");
     registration[i].Estimateproductin(year,registration[i].getInitial_Num_of_livestock(),num_of_members);
     
     System.out.println();
 }
 System.out.println(" <<<<<<<<<<< ESTIMATED PRODUCTION FOR THE ENTIRE PROJECT >>>>>>>>>>> ");
 System.out.println();
 for (int i = 0; i<num_of_members; i++) {
 registration[i].Entireproject();
 System.out.println();
 }
} 

	}

