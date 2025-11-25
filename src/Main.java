import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int contador = 0;
        Scanner palindromo = new Scanner(System.in);
        System.out.println(" --VALIDADOR DE PALINDROMOS-- ");
        System.out.printf("Ingresa la palabra u oracion: ");
        String palabra = palindromo.nextLine();

        if (palabra.isEmpty()) {
            System.out.println("Palabra invalida");
            return;
        }
        int longitud = palabra.length();

        char inicio = palabra.charAt(0);
        char fin =  palabra.charAt(longitud-1);
            for (int i = 0; i < longitud; i++) {

                if (inicio == fin) {

                } else if (inicio != palabra.charAt(longitud - 1)) {
                    contador++;
                }

                //System.exit(0);
            }
            if (contador == 0) {
                System.out.printf("La palabra es un palindromo ");
            } else if (contador != 0) {
                System.out.printf("La palabra no es un palindromo ");
            }
        }
    }
