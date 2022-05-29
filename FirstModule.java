import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class FirstModule
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
        
        System.out.print("Welcome to Modularity Program by Miguel VERSION 1!" + "\n" +
                         "Please select an option: " + "\n" + 
                         "1. Convert a String to upper or lower case" + "\n" +
                         "2. Identify whether there are any numbers in a given String" + "\n" +
                         "3. Identify whether a given String is a valid number or not" + "\n" +
                         "4. Remove any numeric values in a given String and convert String to upper or lower case" + "\n" +
                         "0. Exit");  
        while(continueMenu)
        {
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
            sc.close();
        }
    }

    /**
     * Converts String to upper case or lower case
     */
    public static void convertStringCase()
    {
        String[] caseArray;
        String c = "A1b2C3";
        StringBuilder stringBuild = new StringBuilder();
        int stringLength = c.length();
        caseArray = c.split("(?!^)");
        try
        {
            for(int i = 0; i < caseArray.length; i++)
            {
                for(int j = 0; j < c.length(); j++)
                {
                    if(!Character.isUpperCase(caseArray[i].charAt(j)))
                    {
                        caseArray[i].toLowerCase();
                    }
                    else if(!Character.isLowerCase(caseArray[i].charAt(j)))
                    {
                        caseArray[i].toUpperCase();
                    }
                }
                System.out.println(caseArray[i]);
            }
            for(int j = 0; j < caseArray.length; j++)
            {
                stringBuild.append(caseArray[j]);
            }
            c = stringBuild.toString();
        }
        catch(InputMismatchException error)
        {
            System.out.println("Input error! " + error);
        }
        catch(StringIndexOutOfBoundsException error)
        {
            System.out.println("String out of bounds error! " + error);
        }
    }
}
