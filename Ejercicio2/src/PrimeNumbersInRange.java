import java.util.Scanner;

// Queremos calcular los n�meros primos entre 2 n�meros y imprimirlos por pantalla.
//
//Requisitos:
//
//    lee de la entrada est�ndar 2 n�meros separados por espacio en la primera linea. (Ej: "2 100")
//    Utiliza un thread que realice el trabajo y se encargue de imprimir por pantalla la lista resultante.
//    Utiliza el m�todo de implementar Runnable.
//    El thread principal debe esperar a la finalizaci�n del thread trabajador o "worker".


public class PrimeNumbersInRange {
	
	public static void main(String[] args) {
		// COMPLETA AQU� EL EJERCICIO
		System.out.println("Escribe dos n�meros separados por un espacio");
		String texto = new Scanner(System.in).nextLine();
		int num1=Integer.parseInt(texto.split(" ")[0]);
		int num2=Integer.parseInt(texto.split(" ")[1]);
		Runnable r = new CalcPrimeNumbersRunnable(num1,num2);
		Thread t = new Thread(r);
		t.start();
		
		while(t.isAlive()){}
		
		System.out.print("fin");

	}

}
