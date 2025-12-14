import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = new char[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';

        char turno = 'X';

        while (true) {

            System.out.println("\n  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j]);
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
            }

            // Pedir jugada 1
            System.out.println("\nTurno de " + turno);
            System.out.print("Fila: ");
            int f = sc.nextInt();
            System.out.print("Columna: ");
            int c = sc.nextInt();

            // Valirda
            if (f < 0 || f > 2 || c < 0 || c > 2) {
                System.out.println("Fuera de rango.");
                continue;
            }
            if (tablero[f][c] != ' ') {
                System.out.println("Casilla ocupada.");
                continue;
            }

            // Colocar pieza en la matriz
            tablero[f][c] = turno;

            // Revisar si ganó (FILAS, COLUMNAS Y DIAGONALES)
            if (
                // filas
                    (tablero[0][0] == turno && tablero[0][1] == turno && tablero[0][2] == turno) ||
                            (tablero[1][0] == turno && tablero[1][1] == turno && tablero[1][2] == turno) ||
                            (tablero[2][0] == turno && tablero[2][1] == turno && tablero[2][2] == turno) ||
                            // columnas
                            (tablero[0][0] == turno && tablero[1][0] == turno && tablero[2][0] == turno) ||
                            (tablero[0][1] == turno && tablero[1][1] == turno && tablero[2][1] == turno) ||
                            (tablero[0][2] == turno && tablero[1][2] == turno && tablero[2][2] == turno) ||
                            // diagonales
                            (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) ||
                            (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno)
            ) {
                System.out.println("\n¡Ganó " + turno + "!");
                break;
            }

            // Cambiar turno
            turno = (turno == 'X') ? 'O' : 'X';
        }
    }
}