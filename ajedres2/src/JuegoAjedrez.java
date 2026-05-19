import java.util.Scanner;
import java.util.List;
import java.util.List;
import java.util.ArrayList;
public class JuegoAjedrez {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tablero tablero = new Tablero();

        String turno = "BLANCO";

        while (true) {

            tablero.mostrar();

            System.out.println("Turno: " + turno);

            System.out.print("Selecciona pieza (ejemplo a2): ");
            String origen = sc.nextLine().toLowerCase();

            if (origen.equals("salir")) {
                break;
            }

            int[] pos = Tablero.convertir(origen);

            Pieza pieza = tablero.obtenerPieza(pos[0], pos[1]);

            if (pieza == null) {
                System.out.println("No hay pieza.");
                continue;
            }

            if (!pieza.getColor().equals(turno)) {
                System.out.println("Esa pieza no es tuya.");
                continue;
            }

            List<String> movs = pieza.movimientosValidos(tablero);

            if (movs.isEmpty()) {
                System.out.println("No tiene movimientos.");
                continue;
            }

            System.out.println("Movimientos posibles:");

            for (int i = 0; i < movs.size(); i++) {
                System.out.println((i + 1) + ". " + movs.get(i));
            }

            System.out.print("Elige movimiento: ");
            String destino = sc.nextLine().toLowerCase();

            if (!movs.contains(destino)) {
                System.out.println("Movimiento inválido.");
                continue;
            }

            tablero.mover(origen, destino);

            turno = turno.equals("BLANCO") ? "NEGRO" : "BLANCO";
        }

        sc.close();
    }
}