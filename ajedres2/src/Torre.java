public class Torre extends Pieza {

    public Torre(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'T' : 't');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        if (fila != nuevaFila && columna != nuevaColumna) return false;

        int pasoF = Integer.compare(nuevaFila - fila, 0);
        int pasoC = Integer.compare(nuevaColumna - columna, 0);

        int f = fila + pasoF;
        int c = columna + pasoC;

        while (f != nuevaFila || c != nuevaColumna) {
            if (tablero[f][c] != null) return false;
            f += pasoF;
            c += pasoC;
        }

        return true;
    }
}