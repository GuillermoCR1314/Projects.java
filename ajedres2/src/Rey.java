public class Rey extends Pieza {

    public Rey(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'K' : 'k');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        int df = Math.abs(fila - nuevaFila);
        int dc = Math.abs(columna - nuevaColumna);

        return df <= 1 && dc <= 1;
    }
}