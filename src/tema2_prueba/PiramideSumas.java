package tema2_prueba;
import java.util.Scanner;

public class PiramideSumas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;

        do {
            int numero = leerEntero(sc, "Introduzca un número: "); //AMC20251031 - Falta punto y coma (;) al final de la instrucción.

            while (numero < 0 || numero > 20) {  //AMC20251031 - Corrigo la condición cambiando && por ||, ya que si no, es una condición imposible
                numero = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
            }

            System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(numero));

            System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
            resp = sc.next().trim().toUpperCase(); //AMC20251031 - Quito String ya que la variable esta definida al principio del código

        } while (resp.equals("S")); //AMC20251031 - Falta añadir un paréntesis

        borrarConsola();
        System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");
        
        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("**Valor no válido** Introduzca un número entero: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static void borrarConsola() {
		for (int i = 0; i < 25; i++) { //AMC20251031 - Hay que cambiar la coma, por un punto y coma
			System.out.println();
		}
	}

    public static String piramide(int num) {
        String res = "";
        int n = num;

        while (n >= 0) { //AMC20251031 - Hay que cambiar la condición
            int cont = 1;
            int total = 0;
            res += n + " => 0 ";

            while (cont <= n) { //AMC20251031 - Faltan por añadir los corchetes
                res += "+ " + cont + " ";
                total += cont;
                cont += 1;
            }

            if (n != 0) { /*AMC20251031 - Esta condición no hay que modificarla, no se porque en el examen en 
            			   clase, supongo que por el tiempo y nervios puse otra condición*/
                res += "= " + total;
            }

            res += "\n";
            n -= 1;
        }

        return res; //AMC20251031 - El nombre de la variable es res, no resultado
    }

}