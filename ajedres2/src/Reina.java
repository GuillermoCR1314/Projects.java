public class Reina extends Pieza {

    public Reina(String color, int fila, int columna) {
        super(color, fila, columna, color.equals("BLANCO") ? 'Q' : 'q');
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero) {
        int df = nuevaFila - fila;
        int dc = nuevaColumna - columna;

        // Torre
        if (fila == nuevaFila || columna == nuevaColumna) {
            int pasoF = Integer.compare(df, 0);
            int pasoC = Integer.compare(dc, 0);

            int f = fila + pasoF;
            int c = columna + pasoC;

            while (f != nuevaFila || c != nuevaColumna) {
                if (tablero[f][c] != null) return false;
                f += pasoF;
                c += pasoC;
            }
            return true;
        }

        // Alfil
        if (Math.abs(df) == Math.abs(dc)) {
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

        return false;
    }
}