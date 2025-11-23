public class Adjunta {

    public static void main(String[] args) {

        double[][] matriz = {
            {1, 2, 3},
            {0, 4, 5},
            {1, 0, 6}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        System.out.println("\nMatriz adjunta:");
        double[][] adj = adjunta(matriz);
        imprimirMatriz(adj);
    }

    // Imprimir matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.print(valor + "  ");
            }
            System.out.println();
        }
    }

    // Determinante de una matriz
    public static double determinante(double[][] matriz) {
        int n = matriz.length;

        if (n == 1) {
            return matriz[0][0];
        }

        if (n == 2) {
            return matriz[0][0] * matriz[1][1] -
                   matriz[0][1] * matriz[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matriz[0][j] *
                    determinante(submatriz(matriz, 0, j));
        }

        return det;
    }

    // Obtener submatriz (para cofactores)
    public static double[][] submatriz(double[][] matriz, int fila, int columna) {
        int n = matriz.length;
        double[][] sub = new double[n - 1][n - 1];

        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == fila) continue;

            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == columna) continue;

                sub[r][c] = matriz[i][j];
                c++;
            }
            r++;
        }
        return sub;
    }

    // Calcular matriz de cofactores
    public static double[][] matrizCofactores(double[][] matriz) {
        int n = matriz.length;
        double[][] cofactores = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactores[i][j] = Math.pow(-1, i + j) *
                        determinante(submatriz(matriz, i, j));
            }
        }

        return cofactores;
    }

    // Transponer matriz
    public static double[][] transpuesta(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] trans = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                trans[j][i] = matriz[i][j];
            }
        }
        return trans;
    }

    // Obtener la matriz adjunta
    public static double[][] adjunta(double[][] matriz) {
        return transpuesta(matrizCofactores(matriz));
    }

}
