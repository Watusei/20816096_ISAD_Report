import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class ReUpdateFifthModule
{
    /**
     * 2c. Converts a number which represents a time given in hours to minutes and vice versa, and time given in minutes to seconds and vice versa.
     */
    public static void timeConverter()
    {
        Scanner scan = new Scanner(System.in);
        int numInput = 0;
        int timeInput = 0;
        int select = 0;
        int selectTwo = 1;
        String selectString = "";
        String selectTwoString = "";
        String h = "hour(s)";
        String m = "minute(s)";
        String s = "second(s)";
        boolean continueMenu = true;
        while(continueMenu && select > -1 && select < 4 && selectTwo > 0 && selectTwo < 4)
        {
            try
            {
                System.out.println( "Which would you like to input: " + "\n" +
                                    "1. Hours" + "\n" +
                                    "2. Minutes" + "\n" +
                                    "3. Seconds" + "\n" +
                                    "0. Main");
                select = scan.nextInt();
                System.out.println("You selected: " + select);
                if(select == 1) // HOURS
                {
                    selectString = h;
                    System.out.println( "Which would you like to convert to?" + "\n" +
                                        "1. Minutes" + "\n" +
                                        "2. Seconds" + "\n" +
                                        "3. Back");
                    selectTwo = scan.nextInt();
                    System.out.println("You selected: " + selectTwo);
                    if(selectTwo == 1) // HOURS TO MINUTES
                    {
                        selectTwoString = m;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput*60;
                        continueMenu = false;
                    }
                    else if(selectTwo == 2) // HOURS TO SECONDS
                    {
                        selectTwoString = s;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput*3600;
                        continueMenu = false;
                    }
                    else if(selectTwo == 3) // BACK
                    {
                        timeConverter();
                    }
                    else
                    {
                        System.out.println("Input must be a valid number among the options!");
                    }
                }
                else if(select == 2) // MINUTES
                {
                    selectString = m;
                    System.out.println( "Which would you like to convert to?" + "\n" +
                                        "1. Hours" + "\n" +
                                        "2. Seconds" + "\n" +
                                        "3. Back");
                    selectTwo = scan.nextInt();
                    System.out.println("You selected: " + selectTwo);
                    if(selectTwo == 1) // MINUTES TO HOURS
                    {
                        selectTwoString = h;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput/60;
                        continueMenu = false;
                    }
                    else if(selectTwo == 2) // MINUTES TO SECONDS
                    {
                        selectTwoString = s;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput*60;
                        continueMenu = false;
                    }
                    else if(selectTwo == 3) // BACK
                    {
                        timeConverter();
                    }
                    else
                    {
                        System.out.println("Input must be a valid number among the options!");
                    }
                }
                else if(select == 3) // SECONDS
                {
                    selectString = s;
                    System.out.println( "Which would you like to convert to?" + "\n" +
                                        "1. Hours" + "\n" +
                                        "2. Minutes" + "\n" +
                                        "3. Back");
                    selectTwo = scan.nextInt();
                    System.out.println("You selected: " + selectTwo);
                    if(selectTwo == 1) // SECONDS TO HOURS
                    {
                        selectTwoString = h;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput/3600;
                        continueMenu = false;
                    }
                    else if(selectTwo == 2) // SECONDS TO MINUTES
                    {
                       selectTwoString = s;
                        System.out.println("Enter an integer: ");
                        numInput = scan.nextInt();
                        timeInput = numInput/60;
                        continueMenu = false;
                    }
                    else if(selectTwo == 3) // BACK
                    {
                        timeConverter();
                    }
                    else
                    {
                        System.out.println("Input must be a valid number among the options!");
                    }
                }
                else if(select == 0) 
                {
                    main(null);
                    continueMenu = false;
                }
                else
                {
                    System.out.println("Input must be a valid number among the options!");
                }
            }
            catch(InputMismatchException error)
            {
                System.out.println("Input must be a valid number among the options! " + error);
                continueMenu = false;
            }
        }
        scan.close();
        System.out.println("The time, " + numInput + " " + selectString + ", in " + selectTwoString + " is: " + timeInput + " " + selectTwoString + ".");
    }
}