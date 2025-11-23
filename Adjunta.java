public class Adjunta {

    public static void imprimirMatriz(double[][] m) {
        for (double[] fila : m) {
            for (double v : fila) {
                System.out.printf("%10.4f ", v);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean esCuadrada(double[][] m) {
        if (m == null) return false;
        int n = m.length;
        for (double[] fila : m) {
            if (fila.length != n) return false;
        }
        return true;
    }

    public static double[][] menor(double[][] m, int fila, int col) {
        int n = m.length;
        double[][] res = new double[n - 1][n - 1];
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (i == fila) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                res[r][c] = m[i][j];
                c++;
            }
            r++;
        }
        return res;
    }

    public static double determinante(double[][] m) {
        int n = m.length;
        if (n == 1) return m[0][0];
        if (n == 2)
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];

        double det = 0;
        for (int j = 0; j < n; j++) {
            double[][] sub = menor(m, 0, j);
            double cofactor = ((j % 2 == 0) ? 1 : -1) * m[0][j] * determinante(sub);
            det += cofactor;
        }
        return det;
    }

    // Matriz de cofactores
    public static double[][] matrizCofactores(double[][] m) {
        int n = m.length;
        double[][] cof = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] sub = menor(m, i, j);
                double detSub = determinante(sub);
                cof[i][j] = (((i + j) % 2 == 0) ? 1 : -1) * detSub;
            }
        }

        return cof;
    }
}


