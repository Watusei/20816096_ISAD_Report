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
     * Menu for Modularity Program
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean continueMenu = true;
        int option = 1;
        String input;
        System.out.println("Welcome to Modularity Program by Miguel VERSION 1!" + "\n" +
                               "Please select an option: " + "\n" + 
                               "1. Convert a String to upper or lower case" + "\n" +
                               "2. Identify whether there are any numbers in a given String" + "\n" +
                               "3. Reads a text file of numbers and the total output will be saved to another text file" + "\n" +
                               "4. Remove any numeric values in a given String and convert String to upper or lower case" + "\n" +
                               "5. Convert time between hours, minutes or seconds." + "\n" +
                               "0. Exit");  
        try
        {
            System.out.print("Select an option: ");
            option = sc.nextInt();
        }
        catch(InputMismatchException error)
        {
            System.out.println("Input mismatch error! " + error);
            System.out.println("Input must be an integer between 0 and 5." + "\n");
            continueMenu = false;
        }
        while(continueMenu == true)
        {
            try
            {
                if(option == 1)
                {
                    try
                    {
                        System.out.println("Please enter a String: ");
                        input = sc.nextLine();
                        input = sc.nextLine();
                        System.out.println(convertStringCase(input));
                        System.out.println(""); // PRINT TO NEW LINE
                        continueMenu = false;
                    }
                    catch(InputMismatchException error)
                    {
                        System.out.println("Input must be a String!" + error);
                    }
                }
                else if(option == 2)
                {
                    try
                    {
                        System.out.println("Please enter a String: ");
                        input = sc.nextLine();
                        input = sc.nextLine();
                        System.out.println(isNumberInString(input));
                        System.out.println(""); // PRINT TO NEW LINE
                        continueMenu = false;
                    }
                    catch(InputMismatchException error)
                    {
                        System.out.println("Input must be a String!" + error);
                    }
                }
                else if(option == 3)
                {
                    try
                    {
                        System.out.println("Please enter filename ending in .txt: ");
                        input = sc.nextLine();
                        input = sc.nextLine();
                        readWriteFile(input);
                        System.out.println(""); // PRINT TO NEW LINE
                        continueMenu = false;
                    }
                    catch(InputMismatchException error)
                    {
                        System.out.println("Input must be a String!" + error);
                    }
                }
                else if(option == 4)
                {
                    try
                    {
                        System.out.println("Please enter a String: ");
                        input = sc.nextLine();
                        input = sc.nextLine();
                        System.out.println(categoryB(input));
                        System.out.println(""); // PRINT TO NEW LINE
                        continueMenu = false;
                    }
                    catch(InputMismatchException error)
                    {
                        System.out.println("Input must be a String!" + error);
                    }
                }
                else if(option == 5)
                {
                    timeConverter();
                    System.out.println(""); // PRINT TO NEW LINE
                }
                else 
                {
                    System.out.println("Goodbye!");
                    continueMenu = false;
                }
            }
            catch(InputMismatchException error)
            {
                System.out.println("Input must be as specified type! " + error);
            }
        }
        sc.close();
    }
    
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