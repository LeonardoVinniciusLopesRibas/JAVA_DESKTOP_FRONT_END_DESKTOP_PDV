package projeto.unipar.java_front_end_desktop_pdv.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
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
public class VendaDtoRequest {

    private ArrayList<Double> valorTotalVenda;
    
    public static String marshalToJson(VendaDtoRequest vendaDtoRequest) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(vendaDtoRequest);
    }
}
