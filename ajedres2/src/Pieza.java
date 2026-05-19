import java.util.List;
abstract class Pieza {
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

    public String getColor() {
        return color;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public abstract List<String> movimientosValidos(Tablero tablero);

    protected boolean dentro(int f, int c) {
        return f >= 0 && f < 8 && c >= 0 && c < 8;
    }
}