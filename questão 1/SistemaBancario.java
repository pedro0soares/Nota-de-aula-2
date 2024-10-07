import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do titular: ");
        String titular = sc.nextLine();

        Conta conta = null;
        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(titular);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        int opcao;
        do {
            System.out.println("\nMenu de opções:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            if (conta instanceof ContaCorrente) {
                System.out.println("3. Usar Cheque Especial");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("3. Calcular Rendimento");
                System.out.print("Digite a taxa Selic: ");
                double selic = sc.nextDouble();
                ((ContaPoupanca) conta).calcularRendimento(selic);
            }
            System.out.println("4. Exibir Dados da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.print("Digite o valor a usar do cheque especial: ");
                        double valorChequeEspecial = sc.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorChequeEspecial);
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        sc.close();
    }
}