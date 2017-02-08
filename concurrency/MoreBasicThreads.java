package concurrency;

// Adding more threads
public class MoreBasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			new Thread(new LiftOff()).start();
		System.out.println("Waiting for LiftOff");
	}
}
/**Output
Waiting for LiftOff
#4(9), #0(9), #3(9), #2(9), #3(8), #0(8), #4(8), #1(9), 
#4(7), #0(7), #3(7), #2(8), #2(7), #2(6), #3(6), #0(6), 
#4(6), #1(8), #4(5), #0(5), #3(5), #2(5), #3(4), #0(4), 
#4(4), #1(7), #4(3), #0(3), #3(3), #2(4), #3(2), #3(1), 
#3(Liftoff!), #0(2), #0(1), #0(Liftoff!), #4(2), #1(6), #1(5), #1(4), 
#1(3), #1(2), #1(1), #1(Liftoff!), #4(1), #2(3), #4(Liftoff!), #2(2), #2(1), #2(Liftoff!), 
 * 
 */