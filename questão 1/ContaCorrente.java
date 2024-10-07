class ContaCorrente extends Conta {
    private final double CHEQUE_ESPECIAL = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + CHEQUE_ESPECIAL) {
            saldo -= valor;
            System.out.println("Sacado: " + valor);
        } else {
            System.out.println("Saldo insuficiente! Você pode usar até " + CHEQUE_ESPECIAL + " do cheque especial.");
        }
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= CHEQUE_ESPECIAL) {
            saldo -= valor;
            System.out.println("Usado do cheque especial: " + valor);
        } else {
            System.out.println("Valor excede o limite do cheque especial.");
        }
    }
}