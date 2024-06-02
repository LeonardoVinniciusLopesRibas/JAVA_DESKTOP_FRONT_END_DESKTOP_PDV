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
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;   
    
    public static List<Cliente> unmarshalFromJson(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        List<Cliente> clienteList = mapper.readValue(json, new TypeReference<List<Cliente>>(){});
        return clienteList;
    }
    
    public static Cliente unmarshalFromJsonCliente(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Cliente.class);
    }
    
    public static String marshalToJson(Cliente cliente) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cliente);
    }
    
}
