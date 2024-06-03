package Assignment;

import java.util.*;

public class CollectionsExample {
//	List,Set and Map using Integer & String 
	
	ArrayList<Integer> marksArray = new ArrayList<Integer>();
	HashSet<Integer> ageSet = new HashSet<Integer>();
	HashMap<String, Boolean> studentsResult = new HashMap<String, Boolean>(); 
	
//	ArrayList Initialization 
	public void initializeMarks() {
		marksArray.add(23);
		marksArray.add(54);
		marksArray.add(65);	
	}
	
//	HashSet Initialization
	public void initializeAge() {
		ageSet.add(67);
		ageSet.add(67);  // Duplicate Entry ( Only Unique values will be added in set)
		ageSet.add(78);
		ageSet.add(87);
	}
		
// HashMap Initialization
	public void initializeResult() {
		studentsResult.put("Jhon",true);
		studentsResult.put("Akshat",false);
		studentsResult.put("Denver",true);
		studentsResult.put("Jhon",false); // value of Jhon will become false		
	}
	
//	Accessing Marks
	public int getMarks(int index) {
		int marks = -1;
		try {
			marks = marksArray.get(index);
		}catch(IndexOutOfBoundsException e) {
			// Handle out of bound Exception
		}
		return marks;
	}
	
	
//	Fetching Student Result	
	public boolean getResult(String name) {
		boolean result = studentsResult.get(name);
		return result;
	}
	
//	Sort marks
	public void sortMarks() {
		Collections.sort(marksArray);
	}
	
	
	public static void main(String arg[]) {
		CollectionsExample collections = new CollectionsExample();
		
		collections.initializeMarks(); // Initializing ArrayList
		collections.initializeAge(); // Initializing HashSet
		collections.initializeResult(); // Initializing HashMap
		
		int marks = collections.getMarks(3); // Getting marks at index 3
		boolean result = collections.getResult("Jhon"); // Getting result of "Jhon"
		
		collections.sortMarks(); // ArrayList Sorting
		
		
		
	}
	
	
	

	

}
