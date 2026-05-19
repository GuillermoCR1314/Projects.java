import java.util.List;
import java.util.ArrayList;
class Caballo extends Pieza {

    public Caballo(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'C' : 'c');
    }

    @Override
    public List<String> movimientosValidos(Tablero tablero) {

        List<String> movs = new ArrayList<>();

        int[][] saltos = {
                {-2,-1},{-2,1},
                {-1,-2},{-1,2},
                {1,-2},{1,2},
                {2,-1},{2,1}
        };

        for (int[] s : saltos) {

            int f = fila + s[0];
            int c = columna + s[1];

            if (dentro(f,c)) {

                if (tablero.estaVacio(f,c) ||
                        !tablero.obtenerPieza(f,c).getColor().equals(color)) {

                    movs.add(Tablero.convertir(f,c));
                }
            }
        }

        return movs;
    }
}