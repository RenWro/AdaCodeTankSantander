import java.util.Scanner;

//Questão 2

public class Temperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            System.out.print("Para converter, informe a temperatura: ");
            double temperatura = scanner.nextDouble();

            System.out.print("Qual a unidade de origem dessa temperatura? [C, K, F]: ");
            String unidadeOrigem = scanner.next().toUpperCase();

            System.out.print("Qual a unidade de destino dessa temperatura? [C, K, F]: ");
            String unidadeDestino = scanner.next().toUpperCase();

            double temperaturaConvertida = temperatura;
            boolean conversaoValida = true;

            // Verificar também se as unidades são diferentes
            if (!unidadeOrigem.equals(unidadeDestino)) {
                switch (unidadeOrigem) {
                    case "C":
                        if (unidadeDestino.equals("K")) {
                            temperaturaConvertida = temperatura + 273.15;
                        } else if (unidadeDestino.equals("F")) {
                            temperaturaConvertida = (temperatura * 9 / 5) + 32;
                        } else {
                            conversaoValida = false;
                        }
                        break;
                    case "K":
                        if (unidadeDestino.equals("C")) {
                            temperaturaConvertida = temperatura - 273.15;
                        } else if (unidadeDestino.equals("F")) {
                            temperaturaConvertida = (temperatura - 273.15) * 9 / 5 + 32;
                        } else {
                            conversaoValida = false;
                        }
                        break;
                    case "F":
                        if (unidadeDestino.equals("C")) {
                            temperaturaConvertida = (temperatura - 32) * 5 / 9;
                        } else if (unidadeDestino.equals("K")) {
                            temperaturaConvertida = (temperatura - 32) * 5 / 9 + 273.15;
                        } else {
                            conversaoValida = false;
                        }
                        break;
                    default:
                        conversaoValida = false;
                        break;
                }
            }

            if (conversaoValida) {
                System.out.printf("%.2f %s = %.2f %s\n", temperatura, unidadeOrigem, temperaturaConvertida, unidadeDestino);
            } else {
                System.out.println("Entrada especificada não é válida.");
            }
            // Retornar ao inicio ou finalizar
            System.out.print("Quer converter outra temperatura? (sim/não): ");
            resposta = scanner.next();

        } while (resposta.equalsIgnoreCase("sim"));

        System.out.println("Finalizando conversor.");
        scanner.close();
    }
}
