import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Banco {

    private String nome;

    @Builder.Default
    private List<Conta> contas = new ArrayList<>();

    @Builder.Default
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}

