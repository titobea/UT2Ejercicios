import java.util.Scanner;

// Queremos calcular los n�meros primos entre 2 n�meros y imprimirlos por pantalla.
//
//Requisitos:
//
//    lee de la entrada est�ndar 2 n�meros separados por espacio en la primera linea. (Ej: "2 100")
//    Utiliza un thread que realice el trabajo y se encargue de imprimir por pantalla la lista resultante.
//    Utiliza el m�todo de extender un thread (extends Thread)
//    El thread principal debe esperar a la finalizaci�n del thread trabajador o "worker".


public class PrimeNumbersInRange {
	
	public static void main(String[] args) {
		// COMPLETA AQU� EL EJERCICIO
		System.out.println("Escribe dos n�meros separados por un espacio");
		String texto = new Scanner(System.in).nextLine();
		
		Thread t = new CalcPrimeNumbersThread(texto.split(" "));
		t.start();
		
		while(t.isAlive()){}
		
		System.out.print("fin");

	}

}
