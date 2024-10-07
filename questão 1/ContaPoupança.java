class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Sacado: " + valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void calcularRendimento(double selic) {
        double rendimento;
        if (selic > 8.5) {
            rendimento = saldo * 0.005;
        } else {
            rendimento = saldo * (selic * 0.7 / 100);
        }
        saldo += rendimento;
        System.out.println("Rendimento calculado: " + rendimento);
    }
}