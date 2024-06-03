package Assignment;

import java.util.*;

class StudentDT implements Comparable<StudentDT>{
	public int ID;
	public String name;
	
	public StudentDT(int ID,String name) {
		this.ID = ID;
		this.name = name;
	}
	
	
//	Sorting students by ID
	@Override
	public int compareTo(StudentDT s) {
		return this.ID - s.ID;
	}	
}

// Sorting students by name
class NameCompare implements Comparator<StudentDT>{
	@Override
	public int compare(StudentDT s1, StudentDT s2) {
		return s1.compareTo(s2);
	}
}

public class StudentCollections {
	
	public static void main(String arg[]) {
		StudentDT jhon = new StudentDT(72,"Jhon" );
		StudentDT rohit = new StudentDT(23,"Rohit" );
		StudentDT ashwin = new StudentDT(56,"Ashwin" );
		StudentDT rahul = new StudentDT(01,"Rahul" );
		StudentDT sanjay = new StudentDT(34,"Sanjay" );
		
//		ArrayList of Students
		ArrayList<StudentDT> students = new ArrayList<StudentDT>();
		students.add(jhon);
		students.add(rohit);
		students.add(ashwin);
		students.add(rahul);
		students.add(sanjay);
		
		//		Sorting ArrayList of Students by ID (Comparable)
		Collections.sort(students);
		
		
		//		Sorting ArrayList of Students by name(Comparator)
		NameCompare nameCompare = new NameCompare();
		Collections.sort(students, nameCompare);
		
//		HashSet of Students
		HashSet<StudentDT> uniqueStudents = new HashSet<StudentDT>();
		uniqueStudents.add(jhon);
		uniqueStudents.add(rohit);
		uniqueStudents.add(ashwin);
		uniqueStudents.add(rahul);
		uniqueStudents.add(sanjay);
		uniqueStudents.add(ashwin);  // Duplicate Entry
		
		
//		HashMap of Students 
		HashMap<String, StudentDT> studentRecords = new HashMap<String, StudentDT>();
		studentRecords.put("jhon", jhon);
		studentRecords.put("roht", rohit);
		studentRecords.put("sanjay", sanjay);
		studentRecords.put("rahul", rahul);
		studentRecords.put("ashwin", ashwin);
		
	}

}


