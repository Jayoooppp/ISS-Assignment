package Assignment;


// Abstract class with Abstract methods (Abstraction)
abstract class ElectronicDevice{
	public abstract void setFeatures(String[] features);
	public abstract String[] getFeatures();
}


// Mobile Class
class Mobile extends ElectronicDevice{ // Inheritance
	
	private String[] features;
	public String name;
	public int code;
	public int price;
	
	
	// Default Constructor 
	public Mobile(String name,int code,int price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	// Get & Set methods features (Private Variable) for Encapsulation
	
	@Override   // Polymorphism 
	public void setFeatures(String[] features) {
		// TODO Auto-generated method stub
		this.features = features;
	}
	
	@Override  // Polymorphism
	public String[] getFeatures() {
		// TODO Auto-generated method stub
		return features;
	}
}

//Laptop Class
class Laptop extends ElectronicDevice{ // Inheritance
	
	private String[] features;
	public String name;
	public double version;
	public String manufacturer;
	
	
	// Default Constructor 
	public Laptop(String name,double version,String manufacturer) {
		this.name = name;
		this.version = version;
		this.manufacturer = manufacturer;
	}
	
	
	// Get & Set methods features (Private Variable) for Encapsulation
	
	@Override   // Polymorphism 
	public void setFeatures(String[] features) {
		// TODO Auto-generated method stub
		this.features = features;
	}
	
	@Override  // Polymorphism
	public String[] getFeatures() {
		// TODO Auto-generated method stub
		return features;
	}
	
}




public class OOPS1 {

	public static void main(String arg[]) {

//		Above Two classes are used in OPPS2.java (Intra Package classes)
		
	}
	
}
