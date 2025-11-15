package solver;

public class GaussJordan {
    
	public static double[][] solve(double[][] m) {
		int linhas = m.length;
		int colunas = m[0].length;

		double[][] a = new double[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			System.arraycopy(m[i], 0, a[i], 0, colunas);
		}

		for (int pivo = 0; pivo < linhas; pivo++) {
			double pv = a[pivo][pivo];

			for (int j = 0; j < colunas; j++) {
				a[pivo][j] /= pv;
			}

			for (int r = 0; r < linhas; r++) {
				if (r != pivo) {
					double fator = a[r][pivo];
					for (int c = 0; c < colunas; c++) {
						a[r][c] -= fator * a[pivo][c];
					}
				}
			}
		}

		return a;
	}
}
