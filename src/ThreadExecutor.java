//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     3
//
//  File Name:     ProgramTemplate.java
//
//  Course:        COSC-4302 Operating Systems
//
//  Due Date:      02/24/2022
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       4
//
//  Description:   A multi-threaded program that calculates various 
//                 statistical values for a list of numbers.
//
//********************************************************************

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadExecutor
{
	private Scanner userIn = new Scanner(System.in);
	
    //***************************************************************
    //
    //  Method:       main
    // 
    //  Description:  The main method of the project
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public static void main(String[] args) {
		
		ThreadExecutor obj = new ThreadExecutor();
		obj.developerInfo();
		obj.printInstructions();
		
		ExecutorService pool = Executors.newFixedThreadPool(3); // fixed at 3
		List<Integer> vals = new ArrayList<Integer>(); // to hold input data
		boolean calculate = true; // control variable
		
		/* Continue to perform calculations until 
		 * the user enters a 0 to quit.*/
		do {
			calculate = obj.getValues(vals);
			obj.getStatistics(pool, vals);
			
		} while(calculate);

	}// end main method

    //***************************************************************
    //
    //  Method:       printInstructions (Non Static)
    // 
    //  Description:  Displays simple instructions to the user on how
    //                the use the program.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void printInstructions() {
		
		System.out.println("\nStatistics Calculator");
		System.out.println("----------------------------------------------");
		System.out.println("Enter a list of integers seperated by a space");
		System.out.println("Invalid entries will be ommited");
		System.out.println("Enter 0 to quit");
		System.out.println("----------------------------------------------");	
		
	}// end printInstructions method
	
    //***************************************************************
    //
    //  Method:       getStatistics (Non Static)
    // 
    //  Description:  Submits tasks to the thread pool if a non-empty 
    //                list of data is received. Results are printed
    //                for the user.
    // 
    //  Parameters:   ExecutorService, List<Integer>
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void getStatistics(ExecutorService pool, List<Integer> data) {
		
		if(!data.isEmpty()) {
			
			System.out.println("Data: " + data.toString()); // display the data set
			System.out.println("Getting statistics...");
			Future<Integer> average = pool.submit(new AverageCallable(data)); // gets average
			Future<Integer> min = pool.submit(new MinCallable(data)); // gets minimum
			Future<Integer> max = pool.submit(new MaxCallable(data)); // gets maximum
			
			try {
				
				System.out.println("ave: " + average.get());
				System.out.println("min: " + min.get());
				System.out.println("max: " + max.get());
				
			} catch (InterruptedException | ExecutionException | CancellationException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
	}// end getStatistics method
	
    //***************************************************************
    //
    //  Method:       getInput (Non Static)
    // 
    //  Description:  Gets input from the user.
    // 
    //  Parameters:   None
    //
    //  Returns:      String 
    //
    //**************************************************************
	private String getInput () {
		
		String input = userIn.nextLine();
		return input;
		
	}// end getInput method
	
    //***************************************************************
    //
    //  Method:       getValues (Non Static)
    // 
    //  Description:  Attempts to get a list of values from the user.
    //                If the user enters a non-sentinel value (not 0) 
    //                the input will be forwarded for processing along
    //                with a reference to a list to populate.
    // 
    //  Parameters:   List<Integer>
    //
    //  Returns:      boolean 
    //
    //***************************************************************
	private boolean getValues(List<Integer> dataList) {
		
		boolean calculate = false; // quit flag
		dataList.clear(); // clear any prior values
		System.out.print("Enter values: ");
		String input = getInput();
		
		if(!input.equals("0")) { // check for sentinel value
			
			stringToList(input, dataList); // populate list using input 
			calculate = true; 
			
		} else { 
			
			System.out.println("Goodbye"); // user has entered 0
		}
		
		return calculate;
	
	}//end getValues method
	
    //***************************************************************
    //
    //  Method:       stringToList (Non Static)
    // 
    //  Description:  Populates a list of Integers with any integers 
    //                found in a string (input values). Any value 
    //                that is not able to be parsed into an integer is
    //                omitted. 
    // 
    //  Parameters:   String, List<Integer>
    //
    //  Returns:      N/A 
    //
    //***************************************************************
	private void stringToList(String values, List<Integer> list) { 
		
		// convert string into string array
		String[] strArr = values.replaceAll("\\s+", ",").split(","); 
		
		for(String strVal : strArr) {
			try {
				Integer val = Integer.parseInt(strVal); // attempt to parse int value from string
				list.add(val); // add new Integer to list
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, '" + strVal + "' ommited"); // omit bad input
			}
		}
	}// end stringToList method
	
    //***************************************************************
    //
    //  Method:       printArr (Non Static)
    // 
    //  Description:  Print an int array (input data). 
    // 
    //  Parameters:   int[] 
    //
    //  Returns:      N/A 
    //
    //***************************************************************
	private void printArr(int[] arr) {
		
		System.out.print("[");
		for(int value : arr) {
			System.out.print(" " + value + " ");
		}
		System.out.println("]");
		
	}// end printArr method
	
    //***************************************************************
    //
    //  Method:       developerInfo (Non Static)
    // 
    //  Description:  The developer information method of the program.
    //                It must be included in every program you write
    //                in this course.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void developerInfo()
    {
       System.out.println("Name:    Jeremy Aubrey");
       System.out.println("Course:  COSC 4302 Operating Systems");
       System.out.println("Program: 3");

    }// end developerInfo method
    
}// end ThreadExecutor class
