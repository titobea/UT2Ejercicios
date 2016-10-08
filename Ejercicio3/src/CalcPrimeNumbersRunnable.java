import java.util.List;

public class CalcPrimeNumbersRunnable implements Runnable {
	private int id;
	private int from;
	private int to;
	private Thread previous;
	
	// Nos guardamos el id, inicio, fin, y referencia al Runnablethread anterior
	public CalcPrimeNumbersRunnable(int id, int from, int to, Thread previous) {
		this.id = id;
		this.from = from;
		this.to= to;
		this.previous = previous;
    }
	
	@Override
	public void run() {
		// COMPLETAR AQUÍ EL EJERCICIO
				
		List<Integer> lista = PrimeNumbers.primesInRange(from, to);
		
		if (previous != null){
			while(previous.isAlive()){}
		}
		
		System.out.print("ID:"+id);
		for (int i=0;i<lista.size();i++){
			System.out.print(","+lista.get(i));
		}
		System.out.println();
	}

}
