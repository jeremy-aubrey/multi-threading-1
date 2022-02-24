import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

public class ThreadExecutor
{
	private static Scanner userIn = new Scanner(System.in);
	
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
	public static void main(String[] args)
	{
		// Create an object of the main class and use it to call
		// the non-static developerInfo and other non-static methods
		ThreadExecutor obj = new ThreadExecutor();
		obj.developerInfo();
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		List<Integer> vals = new ArrayList<Integer>();
		boolean calculate = true;
		
		do {
			calculate = obj.getValues(vals);
			obj.getStatistics(pool, vals);
			
		} while(calculate);
		

	} // End of the main method
	
	private void getStatistics(ExecutorService pool, List<Integer> data) {
		
		if(!data.isEmpty()) {
			System.out.println("Data: " + data.toString());
			System.out.println("Getting statistics...");
			Future<Integer> average = pool.submit(new AverageCallable(data));
			Future<Integer> min = pool.submit(new MinCallable(data));
			Future<Integer> max = pool.submit(new MaxCallable(data));
			
			try {
				System.out.println("ave: " + average.get());
				System.out.println("min: " + min.get());
				System.out.println("max: " + max.get());
			} catch (InterruptedException | ExecutionException | CancellationException e) {
				System.out.println("a problem occured calculating average");
			}
		}
	}
	
	private String getInput () {
		String input = userIn.nextLine();
		return input;
	}
	
	private boolean getValues(List<Integer> newList) {
		boolean calculate = false;
		newList.clear(); //clear any prior values
		System.out.println("Enter a list of integers seperated by a space:");
		String input = getInput();
		if(!input.equals("0")) {
			stringToList(input, newList);
			calculate = true;
		} else {
			System.out.println("Goodbye");
		}
		
		return calculate;
	}
	
	private void stringToList(String values, List<Integer> list) { 
		String[] strArr = values.replaceAll("\\s+", ",").split(",");
		
		for(String strVal : strArr) {
			try {
				Integer val = Integer.parseInt(strVal);
				list.add(val);
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, " + strVal + " ommited");
			}
		}
	}
	
	private void printArr(int[] arr) {
		System.out.print("[");
		for(int value : arr) {
			System.out.print(" " + value + " ");
		}
		System.out.println("]");
	}
	
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

    } // End of the developerInfo method
}
