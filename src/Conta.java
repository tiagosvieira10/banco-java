import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Conta {
    private static int SEQUENCIAL = 1;

    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        saldo += valor;
        historico.add(new Transacao(TipoTransacao.DEPOSITO, valor));
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.add(new Transacao(TipoTransacao.SAQUE, valor));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(double valor, Conta destino) {
        if (saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            historico.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor));
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta nº " + numero + " - Cliente: " + cliente.getNome());
        for (Transacao t : historico) {
            System.out.println(t.getData() + " - " + t.getTipo() + ": R$" + t.getValor());
        }
        System.out.println("Saldo atual: R$" + saldo);
    }
}


