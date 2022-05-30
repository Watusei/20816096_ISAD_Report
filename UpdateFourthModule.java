import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class UpdateFourthModule
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
}