package huy.module4casestudy.model.composite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import huy.module4casestudy.model.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class SalaryId implements Serializable {
    private Long id;

    private Integer month;

    private Integer year;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @JsonBackReference
    private Member member;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryId that = (SalaryId) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(month, that.month) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year);
    }
}
