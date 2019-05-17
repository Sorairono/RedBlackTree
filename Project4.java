/**Student name: Long Nguyen
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 4
Description: Create a simple red black tree
*/

/**
 *
 * @author Sorairono
 */
import java.util.*;
import java.io.*;
public class Project4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	//Execute the main part of program if exactly 2 arguments are passed 
		if(args.length == 2)
		{
			//Create two red-black tree: one for integers and one for strings
			RedBlackTree<Integer> itree = new RedBlackTree<>();
			RedBlackTree<String> stree = new RedBlackTree<>();
			try 
			{
				//Scanner for input file
				Scanner inputFile = new Scanner(new File(args[0]));
				//Create a new file for output
				File file = new File(args[1]);
				file.createNewFile();
				//PrintWriter for output file
				PrintWriter outputFile = new PrintWriter(file);
				//Get the first line of input file to know the object 
				String firstLine = inputFile.nextLine().trim();
				//Object is neither integer nor string, print an error message to output file then quit the program
				if (firstLine.equals("Integer") == false && firstLine.equals("String") == false)
				{
					outputFile.print("Only works for objects Integers and Strings");
					outputFile.close();
					System.exit(0);
				}
				//Run through input file till end of it
				while(inputFile.hasNextLine()) 
				{
					//Get the line command
					String input = inputFile.nextLine().trim();
					//Array to store command
		            String[] method = new String[2];
		            //If the command is Insert or Contains and have a number in it, split the command and the number
	            	if(input.contains(":")) 
	            	{
	            		method = input.split(":");
	            	} 
	            	//For other commands
	            	else 
	            	{
	            		method[0] = input;
	            	}
	            	//Switch case to do the appropriate command
	            	switch(method[0]) 
	            	{
	            		//Insert case: check if there is also a key in the command, call the insert method and display error message if key is null
		            	case "Insert": 
		            		if(method[1] == null) 
		            		{
		            			outputFile.println("Error in Line: Insert");
		            		} 
		            		else 
		            		{
	            				if(firstLine.equals("Integer") == true) 
	            				{
	            					int number = Integer.parseInt(method[1]);
	            					boolean insert = itree.insert(number);
	            					outputFile.println(insert);
	            				} 
	            				else 
	            				{
	            					boolean insert = stree.insert(method[1]);
	            					outputFile.println(insert);
	            				}
		            		}
		            		break;
		            	//Contains case: check if there is also a key in the command, call the contains method
		            	case "Contains":
		            		boolean contains = false;
		            		//Return false if given object is null
		            		if(method[1] == null) 
		            		{
		            			outputFile.println(contains);
		            		} 
	            			else if(firstLine.equals("Integer") == true) 
	            			{
	            				int number = Integer.parseInt(method[1]);
	            				contains = itree.contains(number);
	            				outputFile.println(contains);
	            			}
	            			else 
	            			{
	            				contains = stree.contains(method[1]);
	            				outputFile.println(contains);
	            			}
		            		break;
		            	//PrintTree case: call the toString method to print the tree in pre-order traversal
		            	case "PrintTree": 
		            		if(firstLine.equals("Integer") == true) 
		            		{
		            			String str = itree.toString();
		            			outputFile.println(str);
		            		} 
		            		else 
		            		{
		            			String str = stree.toString();
		            			outputFile.println(str);
		            		}
			                break;
			            //Default case: Print out an error message indicating the command is invalid
		            	default:
		            		outputFile.println("Error in Line: " + method[0]);
		            }  
	            } 
	            //Close the files
	            inputFile.close();
                outputFile.close();
			} 
			//Catch exception of being unable to find input file or open file
	        catch(Exception ex) 
	        {
	            System.out.println("File is not found");                 
	        }
		} 
		//If less or more than 2 arguments is passed into the program
		else 
		{
		    System.out.println("Please Input Valid Arguments in Command Line");
		}
		
	}
    
}
