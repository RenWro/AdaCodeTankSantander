import java.util.Scanner;

public class Triangulo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            System.out.print("Insira um número inteiro para o tamanho do triângulo equilátero: ");
            int tamanho = scanner.nextInt();

            desenharTriangulo(tamanho);
            desenharTrianguloInvertido(tamanho);

            System.out.print("Deseja inserir um outro número? (sim/não): ");
            resposta = scanner.next();

        } while (resposta.equalsIgnoreCase("sim"));

        System.out.println("Finalizando código.");
        scanner.close();
    }

    // Parte de cima do triângulo
    private static void desenharTriangulo(int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            for (int x = 0; x < tamanho - i - 1; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < (2 * i + 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Parte de baixo do triângulo
    private static void desenharTrianguloInvertido(int tamanho) {
        for (int i = tamanho - 2; i >= 0; i--) {
            for (int x = 0; x < tamanho - i - 1; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < (2 * i + 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
