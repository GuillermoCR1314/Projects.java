class Tablero {

    private Pieza[][] tablero;

    public Tablero() {
        tablero = new Pieza[8][8];
        iniciar();
    }

    public void iniciar() {

        // PEONES
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon("NEGRO",1,i);
            tablero[6][i] = new Peon("BLANCO",6,i);
        }

        // TORRES
        tablero[0][0] = new Torre("NEGRO",0,0);
        tablero[0][7] = new Torre("NEGRO",0,7);

        tablero[7][0] = new Torre("BLANCO",7,0);
        tablero[7][7] = new Torre("BLANCO",7,7);

        // CABALLOS
        tablero[0][1] = new Caballo("NEGRO",0,1);
        tablero[0][6] = new Caballo("NEGRO",0,6);

        tablero[7][1] = new Caballo("BLANCO",7,1);
        tablero[7][6] = new Caballo("BLANCO",7,6);

        // ALFILES
        tablero[0][2] = new Alfil("NEGRO",0,2);
        tablero[0][5] = new Alfil("NEGRO",0,5);

        tablero[7][2] = new Alfil("BLANCO",7,2);
        tablero[7][5] = new Alfil("BLANCO",7,5);

        // REINAS
        tablero[0][3] = new Reina("NEGRO",0,3);
        tablero[7][3] = new Reina("BLANCO",7,3);

        // REYES
        tablero[0][4] = new Rey("NEGRO",0,4);
        tablero[7][4] = new Rey("BLANCO",7,4);
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == null;
    }

    public Pieza obtenerPieza(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void mover(String origen, String destino) {

        int[] o = convertir(origen);
        int[] d = convertir(destino);

        Pieza p = tablero[o[0]][o[1]];

        tablero[d[0]][d[1]] = p;
        tablero[o[0]][o[1]] = null;

        p.setPosicion(d[0], d[1]);
    }

    public void mostrar() {

        System.out.println("\n   a  b  c  d  e  f  g  h");

        for (int i = 0; i < 8; i++) {

            System.out.print((8 - i) + " ");

            for (int j = 0; j < 8; j++) {

                if (tablero[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + tablero[i][j].getSimbolo() + " ");
                }
            }

            System.out.println(" " + (8 - i));
        }

        System.out.println("   a  b  c  d  e  f  g  h\n");
    }

    public static int[] convertir(String pos) {

        char col = pos.charAt(0);
        char fil = pos.charAt(1);

        int columna = col - 'a';
        int fila = 8 - Character.getNumericValue(fil);

        return new int[]{fila,columna};
    }

    public static String convertir(int fila, int columna) {

        char col = (char) ('a' + columna);
        int fil = 8 - fila;

        return "" + col + fil;
    }
}