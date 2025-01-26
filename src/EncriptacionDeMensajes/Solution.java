package EncriptacionDeMensajes;

import java.util.Iterator;
import java.util.Scanner;

public class Solution {

	public static int casoDePrueba(String frase) {

		// Si esta vacia devuelve 0
		if (frase == null || frase.isEmpty()) {
			return 0;
		}

		// Pasamos a minusculas
		String frasesinMayusculas = frase.toLowerCase();
		int numVocales = 0;
		// Sacamos el primer caracter de la frase
		int posicion = frasesinMayusculas.charAt(0);
		// Calculamos el desplazamiento restandole la p
		int desplazamiento = posicion - 112;

		//Recorremos la frase desde el segundo caracter
		for (int i = 1; i < frasesinMayusculas.length(); i++) {
			//Calclamos la posicion descifrada 
			int posicionDescifrada = frasesinMayusculas.charAt(i) - desplazamiento;
			
			//Hacemos que pueda ir de la a a la z y de la z a la a
			if (posicionDescifrada > 96 && posicionDescifrada < 123) {
				if (posicionDescifrada > 122) {
					posicionDescifrada = (posicionDescifrada - 122) + 96;
				} else if (posicionDescifrada < 97) {
					posicionDescifrada = (posicionDescifrada - 97) + 123;
				}
				
				//Comporbamos si es alguna vocal, si lo es sumamos 1 al contador
				if (posicionDescifrada == 'a' || posicionDescifrada == 'e' || posicionDescifrada == 'i'
						|| posicionDescifrada == 'o' || posicionDescifrada == 'u') {
					numVocales = numVocales + 1;
				}
			}
		}
		//Devoldemos el numero de vocales
		System.out.println(numVocales);
		return numVocales;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		boolean keep = true;
		String codificada;
		int resultado;

		while (keep) {
			codificada = s.nextLine();

			if (codificada.equals("FIN")) {
				keep = false;
			} else {
				resultado = casoDePrueba(codificada);
			}
		}

	}
}