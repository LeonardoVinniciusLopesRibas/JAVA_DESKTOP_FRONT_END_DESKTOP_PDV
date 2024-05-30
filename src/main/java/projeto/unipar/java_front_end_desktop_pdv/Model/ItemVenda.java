package projeto.unipar.java_front_end_desktop_pdv.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVenda {

    private Long id;
    private Venda venda;
    private Produto produto;
    private double quantidade;
    private double preco_unitario;
    private double preco_total;
    private double total;
    
}
