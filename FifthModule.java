import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class FifthModule
{
    private static String input;
    /**
     * Constructor for objects of class Modularity
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean continueMenu = true;
        int option = 1;
        input = "";
        
        while(continueMenu)
        {
            System.out.println("Welcome to Modularity Program by Miguel VERSION 1!" + "\n" +
                               "Please select an option: " + "\n" + 
                               "1. Convert a String to upper or lower case" + "\n" +
                               "2. Identify whether there are any numbers in a given String" + "\n" +
                               "3. Identify whether a given String is a valid number or not" + "\n" +
                               "4. Remove any numeric values in a given String and convert String to upper or lower case" + "\n" +
                               "0. Exit");  
            try
            {
                System.out.print("Select an option: ");
                option = sc.nextInt();
                continueMenu = false;
            }
            catch(InputMismatchException error)
            {
                System.out.println("Input mismatch error! " + error);
                System.out.println("Input must be an integer between 0 and 4." + "\n");
                continueMenu = true;
            }
            if(option == 1)
            {
                try
                {
                    System.out.println("Please enter a String: " + input);
                    input = sc.nextLine();
                    convertStringCase(input);
                }
                catch(InputMismatchException error)
                {
                    System.out.println("Input must be a String!" + error);
                }
            }
            else if(option == 2)
            {
                
            }
            else if(option == 3)
            {
                
            }
            else if(option == 4)
            {
                
            }
            else 
            {
                System.out.println("Goodbye!");
                continueMenu = false;
            }
        }
        sc.close();
    }

    /**
     * 1a. Converts String to upper case or lower case
     */
    public static String convertStringCase(String converted)
    {
        String[] caseArray;
        StringBuilder stringBuild = new StringBuilder();
        caseArray = converted.split("(?!^)");
        for(int i = 0; i < caseArray.length; i++)
        {
            if(caseArray[i].equals(caseArray[i].toLowerCase())) // Check for lower-case characters
            {
                stringBuild.append(caseArray[i].toUpperCase());
            }
            else if(caseArray[i].equals(caseArray[i].toUpperCase())) // Check for upper-case characters
            {
                stringBuild.append(caseArray[i].toLowerCase());
            }
            else // For other characters
            {
                stringBuild.append(caseArray[i]);
            }
        }
        converted = stringBuild.toString();
        return converted;
    }
    
    /**
     * 1b. Identifies whether there are any numbers in a String
     */
    public static boolean isNumberInString(String sentence)
    {
        boolean num = false;
        String[] stringArray; 
        stringArray = sentence.split("(?!^)");
        for(int j = 0; j < stringArray.length; j++)
        {   //Returns true if element matches a number in the form of a String
            if(stringArray[j].matches("-?(0|[1-9]\\d*)"))
            {
                num = true; 
            }
        }
        return num;
    }
    
    /**
     * 1d. Remove any numeric values in a given String and convert String to upper or lower case
     */
    public static String categoryB(String category)
    {
        String categoryPrint = "";
        String[] categoryArray;
        categoryArray = category.split("(?!^)");
        for(int l = 0; l < categoryArray.length; l++)
        {
            if(isNumberInString(categoryArray[l]) == false)
            { // Add non-numbers to String
                categoryPrint += convertStringCase(categoryArray[l]);
            }
            else
            {
                categoryPrint += "";
            }
        }
        return categoryPrint;
    }
    
    /**
     * 2c. Converts a number which represents a time given in hours to minutes and vice versa, and time given in minutes to seconds and vice versa.
     */
    public static String timeConverter()
    {
        Scanner scan = new Scanner(System.in);
        int numInput = 0;
        int timeInput = 0;
        int select = 0;
        int selectTwo = 0;
        String selectString = "";
        String selectTwoString = "";
        String h = "hour(s)";
        String m = "minute(s)";
        String s = "second(s)";
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
                }
                else if(selectTwo == 2) // HOURS TO SECONDS
                {
                    selectTwoString = s;
                    System.out.println("Enter an integer: ");
                    numInput = scan.nextInt();
                    timeInput = numInput*3600;
                }
                else // BACK
                {
                    timeConverter();
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
                }
                else if(selectTwo == 2) // MINUTES TO SECONDS
                {
                    selectTwoString = s;
                    System.out.println("Enter an integer: ");
                    numInput = scan.nextInt();
                    timeInput = numInput*60;
                }
                else // BACK
                {
                    timeConverter();
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
                }
                else if(selectTwo == 2) // SECONDS TO MINUTES
                {
                    selectTwoString = s;
                    System.out.println("Enter an integer: ");
                    numInput = scan.nextInt();
                    timeInput = numInput/60;
                }
                else // BACK
                {
                    timeConverter();
                }
            }
            else 
            {
                main(null);
            }
        }
        catch(InputMismatchException error)
        {
            System.out.println("Input must be a valid number among the options! " + error);
        }
        scan.close();
        return "The time, " + numInput + " " + selectString + " in " + selectTwoString + " is: " + timeInput + " " + selectTwoString + ".";
    }
}