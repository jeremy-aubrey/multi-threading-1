import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<Integer> vals = obj.getValues();
		System.out.println(vals.toString());

	} // End of the main method
	
	public String getInput () {
		String values = userIn.nextLine();
		return values;
	}
	
	public ArrayList<Integer> getValues() {
		System.out.println("Enter a list of integers seperated by a space:");
		String input = getInput();
		ArrayList<Integer> values = toList(input);
		
		return values;
	}
	
	public ArrayList<Integer> toList(String values) { 
		String[] strArr = values.replaceAll("\\s+", ",").split(",");
		ArrayList<Integer> valuesList = new ArrayList<Integer>();
		
		for(String strVal : strArr) {
			try {
				Integer val = Integer.parseInt(strVal);
				valuesList.add(val);
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, " + strVal + " ommited");
			}
		}
		
		return valuesList;
	}
	
	public void printArr(int[] arr) {
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
