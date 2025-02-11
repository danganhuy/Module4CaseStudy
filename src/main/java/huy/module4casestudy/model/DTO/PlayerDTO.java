package huy.module4casestudy.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private BigDecimal height;
    private BigDecimal weight;
    private BigDecimal bmi;
    private Integer ranking;
}
