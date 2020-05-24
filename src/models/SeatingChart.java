package models;

import java.util.*;

public class SeatingChart
{
	//INSTANCE VARIABLE(S)
	private Student[][] seats;
		
	//CONSTRUCTOR
	public SeatingChart(List<Student> studentList, int rows, int cols){ 
		seats=new Student[rows][cols];
		int studentIndex=0;
		for (int col = 0; col < cols; col++){
			for (int row = 0; row < rows; row++){
				if (studentIndex < studentList.size()){
					seats[row][col] = studentList.get(studentIndex);
					studentIndex++;
				}
			}
		} 
	}
	
	//GETTER
	public Student[][] getChart(){
		return seats;
	}
	
	/* This method removes students who have more than a given number of absences from the
	* seating chart, replacing those entries in the seating chart with null
	* and returns the number of students removed. It also counts the number of students
	* that are removed from the student list and returns that value. (unused)
	*/
	/*public int removeAbsentStudents(int allowedAbsences)
	{ 
		int count = 0;
		for (int row=0; row < seats.length; row++){
			for (int col=0; col < seats[0].length; col++){
				if (seats[row][col] != null && seats[row][col].getAbsenceCount() > allowedAbsences){
						seats[row][col]=null;
						count++;
				}
			}
		}
		return count; 
	}*/
}

