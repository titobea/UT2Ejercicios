import java.util.ArrayList;
import java.util.Scanner;

// Queremos calcular los n�meros primos entre 2 n�meros y imprimirlos por pantalla.
//
//  lee de la entrada est�ndar 2 n�meros separados por espacio en la primera linea. (Ej: "1 100")
//  lee de la segunda linea de la entrada est�ndar�ndar el n�meros de threads en los que se tiene que dividir el trabajo.
//  Cada thread debe encargarse de realizar una parte equivativa del c�lculo
//
//    thread 1 [1..50]
//    thread 2 [51..100]
//
//Cada thread debe imprimir por pantalla su id, seguido de la lista de primos en su rango.
//Los ids ser�n asignados en orden incremental por el thread principal de 1 a N.
//Cada thread siempre tiene que esperar a que finalice el thread anterior antes de imprimir!
//Utiliza el m�todo de implementar Runnable.
//El thread principal debe esperar a la finalizaci�n del thread con mayor id (el �ltimo).

public class PrimeNumbersInRange {
	// Ayuda: utiliza esta lista para guardarte la referencia a los threads que crees
	private ArrayList<Thread> threads; 

	public static void main(String[] args) {
		// COMPLETA AQU� EL EJERCICIO
		System.out.println("Escribe dos n�meros separados por un espacio");
		String texto = new Scanner(System.in).nextLine();
		System.out.println("Escribe el n�mero de threads");
		String texto2 = new Scanner(System.in).nextLine();
		int num1=Integer.parseInt(texto.split(" ")[0]);
		int num2=Integer.parseInt(texto.split(" ")[1]);
		int threads=Integer.parseInt(texto2);
		int parte = (num2-num1)/threads;
		Runnable r; 
		Thread t=null;
		for (int i=0;i<threads;i++){
			r = new CalcPrimeNumbersRunnable(i+1,num1+(i*parte),num1+((i+1)*parte),t);
			t = new Thread(r);
			t.start();
		}
		
		while(t.isAlive()){}
		
		System.out.print("fin");

	}

}
