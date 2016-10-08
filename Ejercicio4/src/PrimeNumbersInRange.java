import java.util.ArrayList;
import java.util.Scanner;

// Queremos calcular los n�meros primos entre 2 n�meros y imprimirlos por pantalla.
//
//  lee de la entrada est�ndar 2 n�meros separados por espacio en la primera linea. (Ej: "1 100")
//  lee de la segunda linea de la entrada est�ndar el n�meros de threads en los que se tiene que dividir el trabajo.
//  lee de la 3a linea de la entrada est�ndar el n�mero de segundos m�ximo para realizar la tarea.

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

// ADEMAS:
// El thread principal debe poder cancelar el trabajo de los threads si se sobrepasa el l�mite de tiempo.
// para ello debes utilizar el m�todo interrupt() sobre todos los threads que todav�a est�n
// vivos (con el m�todo isAlive(), por ejemplo)
// Los threads deben intentar acabar imprimiendo los resultados parciales que han obtenido.

public class PrimeNumbersInRange {
	// Ayuda: utiliza esta lista para guardarte la referencia a los threads que crees
	private static ArrayList<Thread> threads; 

	public static void main(String[] args) {
		// COMPLETA AQU� EL EJERCICIO
		
		threads = new ArrayList<>();
		
		System.out.println("Escribe dos n�meros separados por un espacio");
		String texto = new Scanner(System.in).nextLine();
		System.out.println("Escribe el n�mero de threads");
		String texto2 = new Scanner(System.in).nextLine();
		System.out.println("Escribe el n�mero de segundos m�ximo para los hilos");
		String texto3 = new Scanner(System.in).nextLine();
		int num1=Integer.parseInt(texto.split(" ")[0]);
		int num2=Integer.parseInt(texto.split(" ")[1]);
		int numThreads=Integer.parseInt(texto2);
		int parte = (num2-num1)/numThreads;
		int segundos=Integer.parseInt(texto3);
		
		Runnable r; 
		Thread t=null;
		for (int i=0;i<numThreads;i++){
			r = new CalcPrimeNumbersRunnable(i+1,num1+(i*parte),num1+((i+1)*parte),t);
			t = new Thread(r);
			t.start();
			threads.add(t);
		}
		
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			
		}
		
		for (int i = 0; i<threads.size();i++){
			if (threads.get(i).isAlive()){
				threads.get(i).interrupt();
			}
		}
		
		while(t.isAlive()){}
		
		System.out.print("fin");
		
		

	}

}
