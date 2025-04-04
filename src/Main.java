public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = Cliente.builder()
                .nome("Maria Silva")
                .cpf("123.456.789-00")
                .build();

        Cliente cliente2 = Cliente.builder()
                .nome("João Souza")
                .cpf("987.654.321-00")
                .build();

        ContaCorrente cc = new ContaCorrente(cliente1);
        ContaPoupanca cp = new ContaPoupanca(cliente2);

        Banco banco = Banco.builder()
                .nome("Banco Java")
                .build();

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        cc.depositar(1000);
        cc.transferir(250, cp);
        cp.sacar(100);

        cc.imprimirExtrato();
        System.out.println();
        cp.imprimirExtrato();
    }
}
