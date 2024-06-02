package projeto.unipar.java_front_end_desktop_pdv.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemVenda {

    private Long id;
    private Venda venda;
    private Produto produto;
    private double quantidade;
    private double preco_unitario;
    private double preco_total;
    
    public static String marshalVendaToJson(ItemVenda itemVenda) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(itemVenda);
    }
    
}
