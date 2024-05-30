package projeto.unipar.java_front_end_desktop_pdv.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;
    private String descricao;
    private double valor_unitario;
    private String categoria;

    public static List<Produto> unmarshalFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> produtoList = mapper.readValue(json, new TypeReference<List<Produto>>(){});
        return produtoList;
    }
    
    public static String marshalToJson(Produto produto) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(produto);
    }

}
