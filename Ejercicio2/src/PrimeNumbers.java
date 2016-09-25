import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	public static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static List<Integer> primesInRange(int from, int to) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int num=from; num<to; num++) {
			if (isPrime(num)) {
				primes.add(new Integer(num));
			}
		}
		
		return primes;
	}
}
