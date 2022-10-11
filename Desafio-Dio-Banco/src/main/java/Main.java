import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> contas = new ArrayList<>();

        Cliente walace = new Cliente("Walace", 28);
        Cliente matheus = new Cliente("Matheus", 17);

        contas.add(walace);
        contas.add(matheus);

        Banco banco = new Banco("WA", contas);

        ContaCorrente contaCorrenteWalace = new ContaCorrente(walace);
        ContaPoupanca contaPoupancaMatheus = new ContaPoupanca(matheus);

        contaCorrenteWalace.depositar(150);
        contaCorrenteWalace.transferir(50, contaPoupancaMatheus);

        contaCorrenteWalace.imprimirExtrato();
        System.out.println();
        contaPoupancaMatheus.imprimirExtrato();
        System.out.println();

        contaCorrenteWalace.sacar(2500);
        contaCorrenteWalace.imprimirExtrato();
    }
}
