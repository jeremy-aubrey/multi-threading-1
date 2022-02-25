//********************************************************************
//
//  Author:        Jeremy Aubrey
//
//  Program #:     3
//
//  File Name:     MinCallable.java
//
//  Course:        COSC-4302 Operating Systems
//
//  Due Date:      02/24/2022
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       4
//
//  Description:   A class that implements the Callable interface
//                 allowing values to be returned from its call method 
//                 which is executed in a seperate thread. This class
//                 accepts a reference to a list of Integers and calculates
//                 the minimum value.
//
//*********************************************************************

import java.util.List;
import java.util.concurrent.Callable;

public class MinCallable implements Callable<Integer> {
	
	private List<Integer> data; //reference to data
	
	// constructor
	public MinCallable(List<Integer> data) {
		
		this.data = data;
		
	}// end constructor 

    //***************************************************************
    //
    //  Method:       call (Non Static)
    // 
    //  Description:  Iterates through the list of data and returns 
    //                the minimum value if the data list is not empty.
    //
    //  Parameters:   None
    //
    //  Returns:      Integer 
    //
    //***************************************************************
	@Override
	public Integer call() throws Exception {
		
		int min = Integer.MAX_VALUE;
		if(!data.isEmpty()) { //only for a non-empty list
			
			for(Integer num : data) {
				int currentInt = num.intValue();
				if(currentInt < min) {
					min = currentInt;
				}
			}
		}
		
		return new Integer(min);
		
	}// end call method

}// end MinCallable class