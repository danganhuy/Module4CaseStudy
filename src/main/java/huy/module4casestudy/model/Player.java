package huy.module4casestudy.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "player")
public class Player {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Member member;

    @Column(precision = 5, scale = 2)
    private BigDecimal height;

    @Column(precision = 5, scale = 2)
    private BigDecimal weight;

    @Column(precision = 5, scale = 2)
    private BigDecimal bmi;

    private Integer ranking;

    @Column(name = "coach_id")
    private Long coachId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "coach_id")
    private Coach coach;

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
