package Assignment;


//	Interface of Animal
interface Animal{
	public void setSound(String sound);
}

//	Class Definition of Dog
class Dog implements Animal{
	private String sound;
	
	@Override
	public void setSound(String sound) {
		this.sound = sound;
	}	
}

//	Class Definition of Cat
class Cat implements Animal{
	private String sound;
	
	@Override
	public void setSound(String sound) {
		this.sound = sound;
	}
	
}



public class OPPS2 {

	public static void main(String arg[]) {
//		Initializing Mobile class object (Initialized in same package)
		
		Mobile samsung = new Mobile("Samsung",3435,120000);
		String[] samsungFeatures = {"120HZ Display","108MP Camera"};
		
		// Setting and Getting Features
		samsung.setFeatures(samsungFeatures);
		samsungFeatures = samsung.getFeatures();
		
//		Initializing Laptop class object (Initialized in same package)
		
		Laptop dell = new Laptop("Dell",1.20,"Dell Corp");
		
		String[] dellFeatures = {"8gb RAM","Intel i11","RGB Light"};
		dell.setFeatures(dellFeatures);
		dellFeatures = dell.getFeatures();
		
		
//		Initialing object for the above Dog and Cat class
		
		Dog dog1 = new Dog();
		dog1.setSound("Bhaooo Bhaooo");
		
		Cat cat1 = new Cat();
		cat1.setSound("Meow Meow");
		
	}
	
	
}
