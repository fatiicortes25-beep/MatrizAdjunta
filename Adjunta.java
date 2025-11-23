public class Adjunta {

    // (todo el código anterior)

    public static double[][] inversa(double[][] m) {
        if (!esCuadrada(m))
            throw new IllegalArgumentException("La matriz debe ser cuadrada");

        double det = determinante(m);
        if (Math.abs(det) < 1e-12)
            throw new ArithmeticException("La matriz no es invertible (determinante 0)");

        double[][] adj = adjunta(m);
        int n = m.length;
        double[][] inv = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = adj[i][j] / det;
            }
        }

        return inv;
    }
}




