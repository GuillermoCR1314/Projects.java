import java.util.List;
import java.util.ArrayList;
class Peon extends Pieza {

    public Peon(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'P' : 'p');
    }

    @Override
    public List<String> movimientosValidos(Tablero tablero) {
        List<String> movs = new ArrayList<>();

        int dir = color.equals("BLANCO") ? -1 : 1;

        int nuevaFila = fila + dir;

        if (dentro(nuevaFila, columna) && tablero.estaVacio(nuevaFila, columna)) {
            movs.add(Tablero.convertir(nuevaFila, columna));
        }

        return movs;
    }
}