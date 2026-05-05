public class Alfil extends Pieza {

    public Alfil(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'A' : 'a');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        int df = nuevaFila - fila;
        int dc = nuevaColumna - columna;

        if (Math.abs(df) != Math.abs(dc)) return false;

        int pasoF = df > 0 ? 1 : -1;
        int pasoC = dc > 0 ? 1 : -1;

        int f = fila + pasoF;
        int c = columna + pasoC;

        while (f != nuevaFila && c != nuevaColumna) {
            if (tablero[f][c] != null) return false;
            f += pasoF;
            c += pasoC;
        }

        return true;
    }
}