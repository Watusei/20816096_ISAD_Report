import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class UpdateModularityProgram
{
    /**
     * Constructor for objects of class Modularity
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean continueMenu = true;
        int option = 1;
        String input;
        
        while(continueMenu)
        {
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
                System.out.println("Input must be an integer between 0 and 4." + "\n");
                continueMenu = true;
            }
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
                System.out.println(timeConverter());
                System.out.println(""); // PRINT TO NEW LINE
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
     * 1c. Reads a text file of numbers and the total output will be saved to another text file
     */
    public static void readWriteFile(String fileName)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            FileWriter writer = new FileWriter("Total.txt");
            String printTotal;
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) 
            {
                if(isNumberInString(line) == true)
                {
                    int num = Integer.parseInt(line); 
                    total += num;
                }
                else
                {
                    total += 0;
                }
            }
            System.out.print("The total of " + fileName + " equals: " + total + ", has been successfully written to file, 'Total.txt'.");
            printTotal = Integer.toString(total);
            writer.write(printTotal);
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error in file handling: " + e);
            e.printStackTrace();
        }
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
            }
        }
        scan.close();
        return "The time, " + numInput + " " + selectString + ", in " + selectTwoString + " is: " + timeInput + " " + selectTwoString + ".";
    }
}