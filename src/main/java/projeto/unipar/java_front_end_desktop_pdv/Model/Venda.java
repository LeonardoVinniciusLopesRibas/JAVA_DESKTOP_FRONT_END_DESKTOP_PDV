package projeto.unipar.java_front_end_desktop_pdv.Model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    private Long id;
    private Cliente cliente;
    private String observacao;
    private LocalDate data_venda;
    private double total;
    private List<ItemVenda> itens;
    
}
