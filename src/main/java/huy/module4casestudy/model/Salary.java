package huy.module4casestudy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "salary")
@Check(constraints = "salary > 0 AND month > 0 AND month <= 12 AND year > 0")
//@Check(constraints = "month > 0 AND month <= 12 AND year > 0")
public class Salary {
    @EmbeddedId
    private SalaryId id;

    private Double salary;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private Double incentive;
}
