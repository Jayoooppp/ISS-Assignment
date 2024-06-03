package Assignment;

// Abstract class for school members 
abstract class SchoolMembers{
	public abstract String getData();
}

class Student extends SchoolMembers{
	
//	Student attributes (Variable types)
	public String name; // public attribute
	public int age;
	private float percentage; // private attribute 
	public char division;
	protected boolean isPassed; // protected attribute
	final public String school = "J K School"; // final attribute
	
//	Student class Constructor 
	public Student(String name,int age,float percentage,char division,boolean isPassed) {
		this.name = name;
		this.age = age;
		this.percentage = percentage;
		this.division = division;
		this.isPassed = isPassed;
	}
	
//	Overriding abstract class method
	public String getData() {
		return name + age + percentage + division + isPassed + school;
	}
		
}


public class Basic2 {
	
	public static void main(String arg[]) {
		
//		Basic Datatypes 
		
		byte byteData = 12;  // byte datatype 
		
		short shortData = 1000; // short datatype
		
		int intData = 2300020; // int datatype 
		
		long longData = 1243298888; // long datatype
		
		float floatData = 0.34f; // float datatype
		
		double doubleData = 0.5632; // double datatype
		
		boolean booleanData = false; // boolean datatype
		
		char charData = 'd'; // char datatype
		
		
		
//		Initializing Student Object with passing attributes value in constructor
		
		Student jhon = new Student("jhon",12,56.45f,'a',true);
		
	}
	
}
