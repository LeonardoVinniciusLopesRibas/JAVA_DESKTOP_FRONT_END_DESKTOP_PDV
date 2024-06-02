package projeto.unipar.java_front_end_desktop_pdv.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
public class Venda {

    private Long id;
    private Cliente cliente;
    private String observacao;
    private Date data_venda;
    private double total;
    
    public static String marshalVendaToJson(Venda venda) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(venda);
    }
    
    public static Venda unmarshalFromJsonVenda(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Venda.class);
    }
    
}
