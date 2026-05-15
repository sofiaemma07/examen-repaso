package examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		int[] numeros = new int[0];

		do {
			System.out.println("Ingrese la opcion: "
					+ "\n1) Cargar vector" 
					+ "\n2) Mostrar vector"
					+ "\n3) Buscar mínimo y máximo" 
					+ "\n4) Ordenar de menor a mayor" 
					+ "\n5) Ordenar de mayor a menor"
					+ "\n6) Buscar valor" 
					+ "\n7) Promediar" 
					+ "\n8) Salir\n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				numeros = cargarVector();
				break;
			case 2:
				imprimirVector(numeros);
				break;
			case 3:
				int[] maxMin = obtenerMaxMin(numeros);
				imprimirVector(maxMin);
				break;
			case 4:
				int[] copia = ordenarVecMenorMayor(numeros);
				imprimirVector(copia);
				break;
			case 5:
				int[] copia2 = ordenarVecMayorMenor(numeros);
				imprimirVector(copia2);
				break;
			case 6:
				int[] posiciones = encontrarValor(numeros);
				imprimirPosiciones(posiciones);
				break;
			case 7:
				double prom = calcularPromedio(numeros);
				System.out.println("El promedio es: " + prom);
				break;
			default:
				System.out.println("No es una opción válida. Debe ingresar una opcion entre el 1 y el 8.");
				break;
			}

		} while (op != 8);
	}

	public static void imprimirPosiciones(int[] posiciones) {
		if (posiciones.length > 1) {
			System.out.print("El valor " + posiciones[0] + " se encuentra en las posiciones ");
			for (int i = 1; i < posiciones.length; i++) {
				System.out.print(posiciones[i] + ", ");
			}
			System.out.println("\n");
		} else {
			System.out.println("El valor " +  posiciones[0] + " no se encontro.");
		}
	}
	
	public static int[] cargarVector() {
		Scanner sc = new Scanner(System.in);
		int largo;
		int valor;
		boolean error;
		do {
			error = false;
			System.out.println("De que largo desea el vector: ");
			try {
				largo = sc.nextInt();
				int[] numeros = new int[largo];
			
				for (int i = 0; i < numeros.length; i++) {
					do {
						error = false;
						System.out.println("Ingrese el valor " + (i + 1) + ": ");
						try {
							valor = sc.nextInt();
							numeros[i] = valor;
						} catch (InputMismatchException e) {
							System.out.println("Valor ingresado invalido. Debe ingresar un numero entero.");
							sc.nextLine();
							error=true;
						} catch (Exception e) {
							System.out.println("Error inesperado.");
							sc.nextLine();
							error=true;
						}
					} while (error == true);
				}
		
				System.out.println("El vector se ha creado correctamente.");
		
				return numeros;
			} catch (InputMismatchException e){
				System.out.println("Valor ingresado invalido. Debe ingresar un numero entero.");
				sc.nextLine();
				error=true;
			} catch (Exception e) {
				System.out.println("Error inesperado.");
				sc.nextLine();
				error=true;
			}
		} while (error == true);
		return null;
	}

	public static void imprimirVector(int[] numeros) {
		System.out.print("[");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + ", ");
		}
		System.out.print("]\n");
	}

	public static double calcularPromedio(int[] numeros) {
		double prom, acum = 0;
		for (int i = 0; i < numeros.length; i++) {
			acum += numeros[i];
		}
		return prom = (acum) / (numeros.length);
	}

	public static int[] ordenarVecMenorMayor(int[] numeros) {
		int[] copia = new int[numeros.length];

		// LLENO LA COPIA CON LOS VALORES DEL ORIGINAL
		for (int i = 0; i < numeros.length; i++) {
			copia[i] = numeros[i];
		}

		for (int i = 0; i < copia.length; i++) {
			for (int j = 0; j < copia.length - 1 - i; j++) {
				if (copia[j] > copia[j + 1]) {
					int aux = copia[j];
					copia[j] = copia[j + 1];
					copia[j + 1] = aux;
				}
			}
		}
		return numeros;

	}

	public static int[] ordenarVecMayorMenor(int[] numeros) {
		int[] copia = new int[numeros.length];

		// LLENO LA COPIA CON LOS VALORES DEL ORIGINAL
		for (int i = 0; i < numeros.length; i++) {
			copia[i] = numeros[i];
		}

		for (int i = 0; i < copia.length; i++) {
			for (int j = 0; j < copia.length - 1 - i; j++) {
				if (copia[j] < copia[j + 1]) {
					int aux = copia[j];
					copia[j] = copia[j + 1];
					copia[j + 1] = aux;
				}
			}
		}
		return copia;

	}

	public static int[] encontrarValor(int[] vector) {

		Scanner sc = new Scanner(System.in);
		boolean error;
		do {
			error = false;
			System.out.println("Ingrese el valor a buscar");
			try {
				int valor = sc.nextInt();
				int cont = 0;
				for (int i = 0; i < vector.length; i++) {
					if (vector[i] == valor) {
						cont++;
					}
				}
				
				if(cont > 0) {
					int[] posiciones = new int[cont+1];
					posiciones[0] = valor; // EL PRIMER VALOR DEL ARREGLO ES IGUAL AL VALOR BUSCADO
					int posCont = 1;
					for (int i = 1; i < vector.length; i++) {
						if (vector[i] == valor) {
							posiciones[posCont] = i;
							posCont++;
						}
					}
					
					return posiciones;
				} else {
					int[] valorNoEncontrado = new int[1];
					valorNoEncontrado[0] = valor;
					return valorNoEncontrado;
				}
			} catch (InputMismatchException e){
				System.out.println("Valor ingresado invalido. Debe ingresar un numero entero.");
				sc.nextLine();
				error=true;
			} catch (Exception e) {
				System.out.println("Error inesperado.");
				sc.nextLine();
				error=true;
			}
		} while (error == true);
		return null;
	}

	public static int[] obtenerMaxMin(int[] numeros) {
		int i;
		int max = numeros[0];
		int min = numeros[0];

		for (i = 0; i < numeros.length; i++) {

			if (numeros[i] > max) {
				max = numeros[i];
			}

			if (numeros[i] < min) {
				min = numeros[i];
			}

		}

		int[] maxMin = { min, max };

		return maxMin;
	}

}