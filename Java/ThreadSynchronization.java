// Using Thread Synchronization for thread-safety with respect to instance 
// Calculating Fibonacci Series of a Number for which we need thread synchronization
// Synchronization will make sure that first thread executes before second one
// As second thread is dependent on the first thread
package Assignment;

public class ThreadSynchronization {
	
	public volatile static int prev = 0;
	public volatile static int fibonacci = 1;
	
	public static void main(String arg[]) {
		
		int N = 20;
		
		CalculateFibonacci thread1 = new CalculateFibonacci(N/2);
		CalculateFibonacci thread2 = new CalculateFibonacci(N/2);
		
		thread1.start();
		thread2.start();
		
		while(thread1.isAlive() && thread2.isAlive()) {
			// Waiting for both the thread to finish 
		}
		
		int final_ans = fibonacci; // Final fibonacci series output		
	}
	
	static class CalculateFibonacci extends Thread{
		
		public int N;
		public CalculateFibonacci(int N) {
			this.N = N;
		}
		
		public synchronized void run() {
			for(int i = 0;i < N;i++) {
				int temp_ans = prev + fibonacci;
				prev = fibonacci;
				fibonacci = temp_ans;
			}
		}
	}
}
