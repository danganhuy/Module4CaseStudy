package huy.module4casestudy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalaryId implements Serializable {
    private Long id;

    private Integer month;

    private Integer year;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Member member;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

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

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
