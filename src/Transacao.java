import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {
    private TipoTransacao tipo;
    private double valor;

    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    public Transacao(TipoTransacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }
}

