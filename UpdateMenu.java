import java.util.*;
import java.io.*;
/**
 * MODULARITY PROGRAM
 *
 * @Miguel Lima 2081096
 * @V1
 */
public class UpdateMenu
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
                    System.out.println(timeConverter());
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
}
