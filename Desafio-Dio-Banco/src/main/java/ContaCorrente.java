public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        if (cliente.getIdade() > 17) {
            limite = 2000;
        } else {
            limite = 500;
        }
    }

    @Override
    public void imprimirExtrato() {
        imprimirInformacoesBasicas("Corrente");
    }

    @Override
    public void sacar(double valor) {
        if (valor < saldo + limite) {
            this.saldo -= valor;
        } else {
            System.out.println("Operação não realizado por falta de limite");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
