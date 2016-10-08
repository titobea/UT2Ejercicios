import java.util.List;

public class CalcPrimeNumbersThread extends Thread {
		// COMPLETAR AQUÍ EL EJERCICIO
	private int num1; 
	private int num2; 
	public CalcPrimeNumbersThread(String[] valores){
		super("CalcPrimeNumbersThread");
		num1 = Integer.parseInt(valores[0]);
		num2 = Integer.parseInt(valores[1]);
	}
	
	public void run(){
		List<Integer> lista = PrimeNumbers.primesInRange(num1, num2);
		
		for (int i=0;i<lista.size();i++){
			System.out.println(lista.get(i));
		}
		
	}
	
	
}
