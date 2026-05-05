public class Peon extends Pieza {

    public Peon(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'P' : 'p');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        int direccion = color.equals("BLANCO") ? -1 : 1;

        // Movimiento normal
        if (columna == nuevaColumna && tablero[nuevaFila][nuevaColumna] == null) {
            return nuevaFila == fila + direccion;
        }

        // Comer en diagonal
        if (Math.abs(columna - nuevaColumna) == 1 && nuevaFila == fila + direccion) {
            return tablero[nuevaFila][nuevaColumna] != null &&
                    !tablero[nuevaFila][nuevaColumna].getColor().equals(color);
        }

        return false;
    }
}