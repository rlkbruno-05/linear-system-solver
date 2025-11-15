import solver.EliminacaoGauss;
import solver.InputHandler;
import solver.Utils;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Linear System Solver ===");

        double[][] A = InputHandler.lerMatrizDoUsuario();
        double[] b = InputHandler.lerVetorDoUsuario(A.length);

        System.out.println("\nMatriz A:");
        Utils.imprimirMatriz(A);

        System.out.println("\nVetor b:");
        Utils.imprimirVetor(b);

        System.out.println("\n=== RESULTADOS ===");
        EliminacaoGauss.Resultado resultado = EliminacaoGauss.solve(A, b);

        System.out.println("\nTipo de solução: " + resultado.tipoSolucao);
        System.out.printf("Determinante: %.3f\n", resultado.determinante);
        
        if (resultado.sistemaPossivel && resultado.solucao != null) {
            System.out.println("\nSolução do sistema:");
            Utils.imprimirVetor(resultado.solucao);
        } else {
            System.out.println("\nNão há solução única para o sistema.");
        }
    }
}
