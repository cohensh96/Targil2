import java.time.Duration;
import java.time.Duration;
import java.time.Instant;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class TestThreadCheckArray {
	/**
	 * The method initializes an integer arrayList with the wanted size and elements of user,
	 * * The method searches for combination of sums from the array that equal to the given @param number.
	 * 
	 * @param sharedData
	 * Sets and gets necessary flags, also runs the threads to find the wanted sum.
	 * 
	 */
	
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			Thread thread1, thread2;
			System.out.println("Enter array size");
			int num  = input.nextInt();
			ArrayList<Integer> array = new ArrayList<>(num);
			System.out.println("Enter numbers for array");
			
			for (int index = 0; index < num; index++) 
				array.add(index, input.nextInt());
			
			System.out.println("Enter number");
			num = input.nextInt();
			
			
			Instant start = Instant.now(); /////
			
			SharedData sd = new SharedData(array, num);
			
			thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
			thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
			thread1.start();
			thread2.start();
			try 
			{
				thread1.join();
				thread2.join();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (!sd.getFlag())
			{
				System.out.println("Sorry");
				return;
			}
			
			Instant end = Instant.now(); //////
			Duration timeElapsed = Duration.between(start, end);
			
			System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().size());
			System.out.print("I:    ");
			for(int index = 0; index < sd.getArray().size() ; index++)
				System.out.print(index + "    ");
			System.out.println();
			System.out.print("A:    ");
			for (int index : sd.getArray())
			{
				System.out.print(index);
				int counter = 5;
				while (true)
				{
					index = index / 10;
					counter--;
					if (index == 0)
						break;
				}
				for (int i = 0; i < counter; i++)
					System.out.print(" ");
			}

			System.out.println();
			System.out.print("C:    ");
			for (boolean index : sd.getWinArray())
			{
				if (index)
					System.out.print("1    ");
				else
					System.out.print("0    ");	
			}
			
			System.out.println();
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			
		}
	}

}
