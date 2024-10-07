import java.util.Scanner;

public class SistemaUber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a distância percorrida em quilômetros: ");
        double distancia = sc.nextDouble();

        System.out.print("Digite o tempo de espera em minutos: ");
        int tempoEspera = sc.nextInt();

        System.out.print("Digite a tarifa base: R$ ");
        double tarifaBase = sc.nextDouble();

        System.out.print("Digite o fator de demanda (ex: 1.0 para normal, 1.5 para alta demanda): ");
        double fatorDemanda = sc.nextDouble();


        CorridaUber corrida = new CorridaUber(distancia, tempoEspera, tarifaBase, fatorDemanda);


        corrida.exibirDetalhesCorrida();

        sc.close();
    }
}