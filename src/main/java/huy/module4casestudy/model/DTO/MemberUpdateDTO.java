package huy.module4casestudy.model.DTO;

import huy.module4casestudy.model.EMemberType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MemberUpdateDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String hometown;
    private EMemberType memberType;

    // Dữ liệu của Player (chỉ khi memberType là PLAYER)
    private BigDecimal height ;
    private BigDecimal weight ;
    private BigDecimal bmi ;
    private Integer ranking ;
}


