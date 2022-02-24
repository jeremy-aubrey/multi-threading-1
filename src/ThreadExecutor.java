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
		

	} // End of the main method
	
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
