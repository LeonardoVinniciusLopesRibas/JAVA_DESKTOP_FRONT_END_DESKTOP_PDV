package projeto.unipar.java_front_end_desktop_pdv.Dto;

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
public class ItemVendaDtoRequest {
    
    private Long id;
    private String produto;
    private double quantidade;
    private double precoUnitario;
    
    public static List<ItemVendaDtoRequest> unmarshalFromJson(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        List<ItemVendaDtoRequest> itemVendaList = mapper.readValue(json, new TypeReference<List<ItemVendaDtoRequest>>(){});
        return itemVendaList;
    }
    
    public static String marshalToJson(ItemVendaDtoRequest itemVendaDto) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(itemVendaDto);
    }
    
}
