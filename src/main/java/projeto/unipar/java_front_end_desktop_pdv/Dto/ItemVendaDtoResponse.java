package projeto.unipar.java_front_end_desktop_pdv.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaDtoResponse {
    
    private Long id;
    private String nome;
    private double quantidade;
    private double valor;
    private double valor_total;
    
}
