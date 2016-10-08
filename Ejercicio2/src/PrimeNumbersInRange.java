import java.util.Scanner;

// Queremos calcular los números primos entre 2 números y imprimirlos por pantalla.
//
//Requisitos:
//
//    lee de la entrada estándar 2 números separados por espacio en la primera linea. (Ej: "2 100")
//    Utiliza un thread que realice el trabajo y se encargue de imprimir por pantalla la lista resultante.
//    Utiliza el método de implementar Runnable.
//    El thread principal debe esperar a la finalización del thread trabajador o "worker".


public class PrimeNumbersInRange {
	
	public static void main(String[] args) {
		// COMPLETA AQUÍ EL EJERCICIO
		System.out.println("Escribe dos números separados por un espacio");
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
