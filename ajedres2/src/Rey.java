import java.util.List;
import java.util.ArrayList;
class Rey extends Pieza {

    public Rey(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'K' : 'k');
    }

    @Override
    public List<String> movimientosValidos(Tablero tablero) {

        List<String> movs = new ArrayList<>();

        int[][] dirs = {
                {-1,0},{1,0},{0,-1},{0,1},
                {-1,-1},{-1,1},{1,-1},{1,1}
        };

        for (int[] d : dirs) {

            int f = fila + d[0];
            int c = columna + d[1];

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
