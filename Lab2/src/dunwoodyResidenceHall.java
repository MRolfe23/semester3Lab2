import java.util.Scanner;

/**
 * 
 */

/**
 * @author rolmicw
 *
 */
public class dunwoodyResidenceHall {
	public static void main(String[] args)
    {
        String fname, lname, residentType;
        int id, dorm, floor, hoursWorked;
        double rent;
        int EXIT = 1;
        int count = 0;

        final double ATHLETE_RENT = 1200.00;
        final double SCHOLARSHIP_RENT = 100.00;
        final double WORKER_RENT = 1245.00;
        final double BASE_PAY = 14.00;

        int x = 0;
        int SIZE = 20;
        residenceClass[] aResident = new residenceClass[SIZE];
        Scanner reader = new Scanner(System.in);
        

        housekeeping();
        
        try
        {
        	while (x < SIZE && EXIT == 1)
            {
                aResident[x] = new residenceClass();
                java.util.Random generator = new java.util.Random();

                id = generator.nextInt(899999) + 100000;

                System.out.println("Please enter the first name: ");
                fname = reader.next();

                System.out.println("Please enter the last name: ");
                lname = reader.next();

                System.out.println("Please enter the dorm room number: ");
                dorm = reader.nextInt();

                System.out.println("Please enter the floor number: ");
                floor = reader.nextInt();
                
                System.out.println("Please enter the Type of Resident (Athlete, Scholarship, Worker): ");
                residentType = reader.next();
                
                while (!(residentType.equals("Athlete"))&&!(residentType.equals("Scholarship"))&&!(residentType.equals("Worker"))) 
                {
                	System.out.println("Please enter the Type of Resident (Athlete, Scholarship, Worker): ");
                    residentType = reader.next();
                }
                if (residentType.equals("Athlete"))
                {
                    rent = ATHLETE_RENT;
                    hoursWorked = 0;
                }
                else if (residentType.equals("Scholarship"))
                {
                    rent = SCHOLARSHIP_RENT;
                    hoursWorked = 0;
                }
                else
                {
                	System.out.println("Please enter the monthly hours worked (round to whole number): ");
                    hoursWorked = reader.nextInt();
                    rent = WORKER_RENT - (hoursWorked * BASE_PAY) / 2;
                }

                aResident[x].ID = id;
                aResident[x].fname = fname;
                aResident[x].lname = lname;
                aResident[x].dorm = dorm;
                aResident[x].floor = floor;
                aResident[x].residentType = residentType;
                aResident[x].hoursWorked = hoursWorked;
                aResident[x].rent = rent;

                x++;
                count++;
                System.out.println("enter 1 to enter another resident or -1 to exit program: ");
                EXIT = reader.nextInt();
            }
        }
        catch (ArithmeticException e)
        {
           System.out.println("Can't do that!");
        }


        x = 0;
        System.out.println("=========================================");
        
        try
        {
        	while (x < count)
            {
            	System.out.println(aResident[x].ToString());
            	System.out.println("=========================================");
                x++;
            }
        }
        catch (ArithmeticException e)
        {
           System.out.println("Can't do that!");
        }

        reader.close();
        closinghouse();
    }

    public static void housekeeping()
    {
    	System.out.println("Welcome to the Dunwoody Residence Hall input system");
    	System.out.println("This program will require your input of the following information");
    	System.out.println("Please fill out all information");
    	System.out.println("=================================================================");
    }

    public static void closinghouse()
    {
    	System.out.println("Thank you for the input for the new residents!");
    	System.out.println("This program has concluded. Please hit any button to quit the program....");
    	System.console().readLine();
    }
}
class residenceClass
{
    public int ID;
    public String fname;
    public String lname;
    public int dorm;
    public int floor;
    public String residentType;
    public double hoursWorked;
    public double rent;


    public residenceClass()
    {

    }
    public residenceClass(int ID, String fname, String lname, int dorm, int floor, String residentType, double hoursWorked, double rent)
    {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.dorm = dorm;
        this.floor = floor;
        this.residentType = residentType;
        this.hoursWorked = hoursWorked;
        this.rent = rent;
    }
    public java.lang.String ToString()
    {
        return "Resident ID: " + ID + " First Name: " + fname + " Last Name: " + lname + " Dorm Room: " + dorm + " Floor: " + floor + " Resident Type: " + residentType + " Hours Working: " + hoursWorked + " Monthly Rent: $" + rent;
    }
}
