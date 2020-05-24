package models;

import java.util.ArrayList;

public class StudentList {
	
	//INSTANCE VARIABLE(S)
	private ArrayList<Student> _a;
	
	//CONSTRUCTOR
	public StudentList() {
		_a = new ArrayList<Student>();
	}
	
	//GETTER
	public ArrayList<Student> getList(){
		return _a;
	}
	
	/* This method removes students who have more than a given number of absences from the
	* seating chart, replacing those entries in the seating chart with null
	* and returns the number of students removed. It also counts the number of students
	* that are removed from the student list and returns that value. (unused)
	*/
	public int removeAbsentStudents(int allowedAbsences)
	{ 
		int count = 0;
		for (int row=0; row < _a.size(); row++){
			if (_a.get(row).getAbsenceCount() > allowedAbsences){
				_a.remove(row);
				count++;
			}
		}
		return count; 
	}
}
