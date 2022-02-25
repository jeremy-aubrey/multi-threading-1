//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     3
//
//  File Name:     MaxCallable.java
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
//                 the maximum value.
//
//*********************************************************************

import java.util.List;
import java.util.concurrent.Callable;

public class MaxCallable implements Callable<Integer>{
	
	private List<Integer> data; //reference to data
	
	// constructor
	public MaxCallable(List<Integer> data) {
		
		this.data = data;
		
	}// end constructor
	
    //***************************************************************
    //
    //  Method:       call (Non Static)
    // 
    //  Description:  Iterates through the list of data and returns 
    //                the maximum value if the data list is not empty.
    //
    //  Parameters:   None
    //
    //  Returns:      Integer 
    //
    //***************************************************************
	@Override
	public Integer call() throws Exception {
		
		int max = Integer.MIN_VALUE;
		if(!data.isEmpty()) { //only for a non-empty list
			
			for(Integer num : data) {
				int currentInt = num.intValue();
				if(currentInt > max) {
					max = currentInt;
				}
			}
		}
		
		return new Integer(max);
		
	}// end call method

}// end MaxCallable class