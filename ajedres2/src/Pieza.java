public abstract class Pieza {
    protected String color;
    protected int fila;
    protected int columna;
    protected char simbolo;

    public Pieza(String color, int fila, int columna, char simbolo) {
        this.color = color;
        this.fila = fila;
        this.columna = columna;
        this.simbolo = simbolo;
    }

    public abstract boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] tablero);

    public String getColor() {
        return color;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }
}