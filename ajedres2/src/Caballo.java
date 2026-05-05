public class Caballo extends Pieza {

    public Caballo(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'C' : 'c');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        int df = Math.abs(fila - nuevaFila);
        int dc = Math.abs(columna - nuevaColumna);

        return (df == 2 && dc == 1) || (df == 1 && dc == 2);
    }
}