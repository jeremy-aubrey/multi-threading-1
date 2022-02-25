//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     3
//
//  File Name:     AverageCallable.java
//
//  Course:        COSC-4302 Operating Systems
//
//  Due Date:      02/26/2022
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       4
//
//  Description:   A class that implements the Callable interface
//                 allowing values to be returned from its call method 
//                 which is executed in a seperate thread. This class
//                 accepts a reference to a list of Integers and calculates
//                 the average value.
//
//*********************************************************************

import java.util.List;
import java.util.concurrent.Callable;

public class AverageCallable implements Callable<Integer> {
	
	private List<Integer> data; //reference to data
	
	// constructor
	public AverageCallable(List<Integer> data) {
		
		this.data = data;
		
	}// end constructor
	
    //***************************************************************
    //
    //  Method:       call (Non Static)
    // 
    //  Description:  Iterates through the list of data and returns 
    //                the average if the data list is not empty.
    //
    //  Parameters:   None
    //
    //  Returns:      Integer 
    //
    //***************************************************************
	@Override
	public Integer call() throws Exception {
		
		int avg = 0;
		if(!data.isEmpty()) { //only for a non-empty list
			
			int sum = 0;
			for(Integer num : data) {
				sum += num.intValue();
			}
			
			avg = sum / data.size();
		}
		
		return new Integer(avg);
		
	}// end call method

}// end AverageCallable class