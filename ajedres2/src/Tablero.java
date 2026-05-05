public class Tablero {
    private Pieza[][] tablero;

    public Tablero() {
        tablero = new Pieza[8][8];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon("NEGRO", 1, i);
            tablero[6][i] = new Peon("BLANCO", 6, i);
        }

        tablero[0][0] = new Torre("NEGRO", 0, 0);
        tablero[0][7] = new Torre("NEGRO", 0, 7);
        tablero[7][0] = new Torre("BLANCO", 7, 0);
        tablero[7][7] = new Torre("BLANCO", 7, 7);

        tablero[0][1] = new Caballo("NEGRO", 0, 1);
        tablero[0][6] = new Caballo("NEGRO", 0, 6);
        tablero[7][1] = new Caballo("BLANCO", 7, 1);
        tablero[7][6] = new Caballo("BLANCO", 7, 6);

        tablero[0][2] = new Alfil("NEGRO", 0, 2);
        tablero[0][5] = new Alfil("NEGRO", 0, 5);
        tablero[7][2] = new Alfil("BLANCO", 7, 2);
        tablero[7][5] = new Alfil("BLANCO", 7, 5);

        tablero[0][3] = new Reina("NEGRO", 0, 3);
        tablero[7][3] = new Reina("BLANCO", 7, 3);

        tablero[0][4] = new Rey("NEGRO", 0, 4);
        tablero[7][4] = new Rey("BLANCO", 7, 4);
    }

    public void mostrar() {
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] == null)
                    System.out.print(". ");
                else
                    System.out.print(tablero[i][j].getSimbolo() + " ");
            }
            System.out.println();
        }
        System.out.println("  0 1 2 3 4 5 6 7");
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public boolean mover(int f1, int c1, int f2, int c2) {
        if (f2 < 0 || f2 >= 8 || c2 < 0 || c2 >= 8) return false;

        Pieza pieza = tablero[f1][c1];
        if (pieza == null) return false;

        Pieza destino = tablero[f2][c2];
        if (destino != null && destino.getColor().equals(pieza.getColor())) return false;

        if (pieza.esMovimientoValido(f2, c2, tablero)) {
            tablero[f2][c2] = pieza;
            tablero[f1][c1] = null;
            pieza.mover(f2, c2);
            return true;
        }

        return false;
    }
}