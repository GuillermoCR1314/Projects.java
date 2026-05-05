import java.util.Scanner;

public class JuegoAjedrez {
    public static void main(String[] args) {

        Tablero tablero = new Tablero();
        Scanner sc = new Scanner(System.in);

        String turno = "BLANCO";

        while (true) {
            tablero.mostrar();
            System.out.println("Turno: " + turno);

            // 🔥 INPUT CORREGIDO
            System.out.print("Fila origen (1-8): ");
            int f1 = 8 - sc.nextInt();

            System.out.print("Columna origen (0-7): ");
            int c1 = sc.nextInt();

            System.out.print("Fila destino (1-8): ");
            int f2 = 8 - sc.nextInt();

            System.out.print("Columna destino (0-7): ");
            int c2 = sc.nextInt();

            // 🔒 Validar rango (evita errores)
            if (f1 < 0 || f1 > 7 || c1 < 0 || c1 > 7 ||
                    f2 < 0 || f2 > 7 || c2 < 0 || c2 > 7) {
                System.out.println("Fuera del tablero");
                continue;
            }

            Pieza pieza = tablero.getTablero()[f1][c1];

            if (pieza == null) {
                System.out.println("No hay pieza ahí");
                continue;
            }

            if (!pieza.getColor().equals(turno)) {
                System.out.println("Esa pieza no es tuya");
                continue;
            }

            if (tablero.mover(f1, c1, f2, c2)) {
                turno = turno.equals("BLANCO") ? "NEGRO" : "BLANCO";
            } else {
                System.out.println("Movimiento inválido");
            }
        }
    }
}