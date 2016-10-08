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
	
	// TODO: Modifica el m�todo para que sea capaz de lanzar
	// una interrupci�n InterruptedException en caso de que en el hilo
	// en el que se ejecuta el m�todo (Thread.currentThread()) se haya
	// recibido un flag interrupt (isInterrupted())
	// Esta comprobaci�n debe hacerse al menos una vez en cada iteraci�n
	public static List<Integer> primesInRange(int from, int to) throws InterruptedException {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int num=from; num<to; num++) {
			if (Thread.currentThread().isInterrupted()){					
				return primes;				
			}else{
				if (isPrime(num)) {
					primes.add(new Integer(num));
				}
			}			
		}
		
		return primes;
	}
}
