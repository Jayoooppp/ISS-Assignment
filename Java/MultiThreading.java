// In below program we want to add addition of first N and First M natural numbers
// Output = Addition(First N) + Addition(First M)
// We will be using MultiThreading to perform addition 
package Assignment;



public class MultiThreading {
		 
	private  volatile static int total = 0; // volatile variable (Shared Variable)
	public static void main(String arg[]) {
		
//		Creating thread objects
		AddFirstN thread1 = new AddFirstN(120);
		AddFirstN thread2 = new AddFirstN(300);
		
//		Calling thread objects
		thread1.start();
		thread2.start();
		
		while(thread1.isAlive() && thread2.isAlive()) {
			// Waiting for both threads to finish execution
		}
		
		int finalOutput = MultiThreading.total; // Final Output Calculation
	}
	
	static class AddFirstN extends Thread{ // Thread Class
		public int N; // local thread variable
		
		public AddFirstN(int N) {
			this.N = N;
		}
		
		public void run() {
			// Calculating addition of first N Numbers
			for(int i = 0;i <= N;i++) {
				total += i;
			}
		}
	}

	
}
