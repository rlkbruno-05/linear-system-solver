package solver;

public class EliminacaoGauss {

    public static class Resultado {
        public double[] solucao;
        public String tipoSolucao;
        public double determinante;
        public boolean sistemaPossivel;

        public Resultado(double[] solucao, String tipoSolucao, double determinante, boolean sistemaPossivel) {
            this.solucao = solucao;
            this.tipoSolucao = tipoSolucao;
            this.determinante = determinante;
            this.sistemaPossivel = sistemaPossivel;
        }
    }

    public static Resultado solve(double[][] A, double[] b) {
        if (A == null || b == null) {
            throw new IllegalArgumentException("A e b não podem ser nulos");
        }
        int n = A.length;
        if (n == 0 || b.length != n) {
            throw new IllegalArgumentException("Dimensões inválidas");
        }
        for (double[] row : A) {
            if (row.length != n) {
                throw new IllegalArgumentException("Matriz A deve ser quadrada");
            }
        }

        double[][] M = new double[n][n];
        double[] rhs = new double[n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, M[i], 0, n);
            rhs[i] = b[i];
        }

        double determinante = 1.0;
        int trocas = 0;

        for (int k = 0; k < n; k++) {
            int pivotRow = k;
            double max = Math.abs(M[k][k]);
            for (int i = k + 1; i < n; i++) {
                double val = Math.abs(M[i][k]);
                if (val > max) {
                    max = val;
                    pivotRow = i;
                }
            }

            if (pivotRow != k) {
                double[] tmp = M[k];
                M[k] = M[pivotRow];
                M[pivotRow] = tmp;

                double t = rhs[k];
                rhs[k] = rhs[pivotRow];
                rhs[pivotRow] = t;
                trocas++;
            }

            if (Math.abs(M[k][k]) < 1e-12) {
                determinante = 0.0;
                
                boolean todasZero = true;
                for (int j = 0; j < n; j++) {
                    if (Math.abs(M[k][j]) > 1e-12) {
                        todasZero = false;
                        break;
                    }
                }
                
                if (todasZero && Math.abs(rhs[k]) > 1e-12) {
                    return new Resultado(null, "Nenhuma solução", 0.0, false);
                }
                else if (todasZero && Math.abs(rhs[k]) < 1e-12) {
                    return new Resultado(null, "Infinitas soluções", 0.0, true);
                }
            }

            determinante *= M[k][k];

            for (int i = k + 1; i < n; i++) {
                double factor = M[i][k] / M[k][k];
                for (int j = k + 1; j < n; j++) {
                    M[i][j] -= factor * M[k][j];
                }
                rhs[i] -= factor * rhs[k];
                M[i][k] = 0.0;
            }
        }

        if (trocas % 2 != 0) {
            determinante = -determinante;
        }

        if (Math.abs(determinante) < 1e-12) {
            if (Math.abs(rhs[n-1]) < 1e-12) {
                return new Resultado(null, "Infinitas soluções", determinante, true);
            } else {
                return new Resultado(null, "Nenhuma solução", determinante, false);
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = rhs[i];
            for (int j = i + 1; j < n; j++) {
                sum -= M[i][j] * x[j];
            }
            x[i] = sum / M[i][i];
        }

        return new Resultado(x, "Solução única", determinante, true);
    }
}
