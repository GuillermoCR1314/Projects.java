import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean haganado=false;
        Stack p1 = new Stack();
        Stack p2 = new Stack();
        Stack p3 = new Stack();

        p1.push("------\n");
        p1.push("----\n");
        p1.push(" --");


        System.out.print("--Bienvenidos-- \n");
        System.out.printf("-Torres de Hanoi-\n");
        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");

        do {


        //Movimientos
        System.out.println("Seleccione la Columna origen");
        int opc = scanner.nextInt();
        System.out.println("Seleccione la Columna destino");
        int opc2 = scanner.nextInt();
        switch (opc) {
            case 1:
                if (opc2 == 2) {
                    p2.push(p1.pop());
                    System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");

                 } else if (opc2 == 3) {
                    p3.push(p1.pop());
                    System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                }
                break;
            case 2:
                if (opc2 == 1) {
                    p1.push(p2.pop());
                    System.out.printf("" + p2);
                } else if (opc2 == 3) {
                    p3.push(p2.pop());
                    System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                }
                break;
            case 3:
                if (opc2 == 1) {
                    p1.push(p3.pop());
                    System.out.printf("" + p2);
                } else if (opc2 == 2) {
                    p2.push(p3.pop());
                    System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                }
                break;
        }
        } while (!haganado);
        }
        /*
        System.out.printf(""+p3);*/

        }
