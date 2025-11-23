public class MatrizAdjunta {

    // Imprime una matriz
    public static void imprimirMatriz(double[][] m) {
        for (double[] fila : m) {
            for (double v : fila) {
                System.out.printf("%10.4f ", v);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Verifica si es una matriz cuadrada
    public static boolean esCuadrada(double[][] m) {
        if (m == null) return false;
        int n = m.length;
        for (double[] fila : m) {
            if (fila.length != n) return false;
        }
        return true;
    }
}

