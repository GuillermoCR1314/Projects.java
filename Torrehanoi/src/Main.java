import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean haganado=false;
        int i,ante,ante2;
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();

        p1.push(3);
        p1.push(2);
        p1.push(1);

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
                    if (!p1.isEmpty() && (p2.isEmpty() || p1.peek() < p2.peek())) {
                        p2.push(p1.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }
                } else if (opc2 == 3) {
                    if (!p1.isEmpty() && (p3.isEmpty() || p1.peek() < p3.peek())) {
                        p3.push(p1.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }

                }
                break;
            case 2:
                if (opc2 == 1) {
                    if (!p2.isEmpty() && (p1.isEmpty() || p2.peek() < p1.peek())) {
                        p1.push(p2.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }
                } else if (opc2 == 3) {
                    if (!p2.isEmpty() && (p3.isEmpty() || p2.peek() < p3.peek())) {
                        p3.push(p2.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }
                }
                break;
            case 3:
                if (opc2 == 1) {
                    if (!p3.isEmpty() && (p1.isEmpty() || p3.peek() < p1.peek())) {
                        p1.push(p3.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }
                } else if (opc2 == 2) {
                    if (!p3.isEmpty() && (p2.isEmpty() || p3.peek() < p2.peek())) {
                        p2.push(p3.pop());
                        System.out.printf("" + p1 + " " + p2 + " " + p3 + "\n");
                    } else {
                        System.out.printf("Opcion invalida\n");
                    }
                }
                break;
        }
        ante2 = 3;

        if (p1.isEmpty() && p2.isEmpty() && p3.size() == 3) {
            /*for (i=p3.size()-1; i>=0; i--) {
                ante=p3.get(i);
                if(ante<=ante){
                    System.out.printf("Ganaste");
                }
                ante2=p3.get(i);
            }*/
            System.out.printf("\nHAGANADO!\n");
            haganado=true;
        }
        } while (!haganado);
        }
        /*
        System.out.printf(""+p3);*/

        }
