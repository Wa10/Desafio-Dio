import lombok.Getter;

@Getter
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int numeroConta = 1;

    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.numero = numeroConta++;
        this.cliente = cliente;
    }

    protected abstract void imprimirExtrato();

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInformacoesBasicas(String tipoConta) {
        System.out.println(
                "--> Extrato Conta " + tipoConta + " <--" +
                "\n" + "Cliente: " + this.cliente.getNome() +
                "\n" + "Agencia: " + this.AGENCIA_PADRAO +
                "\n" + "Numero: " + this.numero +
                "\n" + "Saldo: " + this.saldo
        );
    }
}
