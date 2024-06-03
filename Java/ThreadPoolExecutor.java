// Below is the problem to find minimum value from large array
// Thus Thread Pool is used to distribute the work across all the threads 
package Assignment;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor {
	
	volatile static int minimum_val = 1001;
	volatile static int[] arr = new int[100];
	
	public static void main(String arg[]) {
		
	//	Initializing value of the array
		// create instance of Random class
		Random rand = new Random();
		for(int i = 0;i < 100;i++) {
			arr[i] = rand.nextInt(1000); // Random value between 0 to 1000
		}
		
	//  creating 5 Tasks
		Runnable r1 = new CalculateMinimum(0, 20);
		Runnable r2 = new CalculateMinimum(20, 40);
		Runnable r3 = new CalculateMinimum(40, 60);
		Runnable r4 = new CalculateMinimum(60, 80);
		Runnable r5 = new CalculateMinimum(80, 100);
		
	//	Creating a thread pool with MAX 3 Threads
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
	//	Passing thread objects to the pool to execute	
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
		
		int final_output = minimum_val; // Minimum value from entire array 
		
		
	}
	
	
//	Thread class for finding minimum between a range 
	static class CalculateMinimum implements Runnable{
		
		public int start;
		public int end;
		
		public CalculateMinimum(int start,int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public void run() {
			for(int i = start;i < end;i++) {
				minimum_val = Math.min(minimum_val , arr[i]);
			}
		}
		
	}
	
}
