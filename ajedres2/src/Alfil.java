import java.util.List;
import java.util.ArrayList;
class Alfil extends Pieza {

    public Alfil(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'A' : 'a');
    }

    @Override
    public List<String> movimientosValidos(Tablero tablero) {

        List<String> movs = new ArrayList<>();

        int[][] dirs = {
                {-1,-1},{-1,1},{1,-1},{1,1}
        };

        for (int[] d : dirs) {

            int f = fila;
            int c = columna;

            while (true) {

                f += d[0];
                c += d[1];

                if (!dentro(f,c)) break;

                if (tablero.estaVacio(f,c)) {
                    movs.add(Tablero.convertir(f,c));
                } else {

                    if (!tablero.obtenerPieza(f,c).getColor().equals(color)) {
                        movs.add(Tablero.convertir(f,c));
                    }

                    break;
                }
            }
        }

        return movs;
    }
}