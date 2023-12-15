import java.util.Scanner;

//Questão 1

public class CalculoAmortizacaoSAC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            System.out.print("Insira o valor que deseja em empréstimo (sem pontos e a vírgula será considerada centavos): ");
            double total_saldo_devedor = scanner.nextDouble();

            System.out.print("Insira a taxa de juros mensal (em %): ");
            double juros_ao_mes = scanner.nextDouble() / 100;

            System.out.print("Insira o total de meses para pagamento: ");
            int total_de_meses = scanner.nextInt();

            double amortizacao = total_saldo_devedor / total_de_meses;
            double saldo_devedor_atual = total_saldo_devedor;

            System.out.println("\nValor fixo da amortização R$ " + String.format("%.2f", amortizacao) +
                    ", Saldo devedor total R$ " + String.format("%.2f", total_saldo_devedor) +
                    " com um juros de " + String.format("%.2f", juros_ao_mes * 100) + "% ao mês");

            double total_juros_pagos = 0;
            double total_pago_em_prestacoes = 0;

            for (int mes = 1; mes <= total_de_meses; mes++) {
                double juros_mensal = saldo_devedor_atual * juros_ao_mes;
                double parcela_mensal = juros_mensal + amortizacao;

                saldo_devedor_atual -= amortizacao;
                total_juros_pagos += juros_mensal;
                total_pago_em_prestacoes += parcela_mensal;

                System.out.println("Parcela do mês " + mes + " | Juros: R$ " + String.format("%.2f", juros_mensal) +
                        " | Prestação: R$ " + String.format("%.2f", parcela_mensal) +
                        " | Saldo devedor: R$ " + String.format("%.2f", saldo_devedor_atual));
            }

            System.out.println("\nSeu total é: Prestação R$ " + String.format("%.2f", total_pago_em_prestacoes) +
                    ", com juros de R$ " + String.format("%.2f", total_juros_pagos) +
                    ", e amortização de R$ " + String.format("%.2f", total_saldo_devedor));

            // Pergunta final para retornar o código
            System.out.print("Você deseja calcular um novo valor? (sim/não): ");
            resposta = scanner.next();

        } while (resposta.equalsIgnoreCase("sim"));

        System.out.println("Obrigada. Até logo.");
        scanner.close();
    }
}
