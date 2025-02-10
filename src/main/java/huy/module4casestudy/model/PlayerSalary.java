package huy.module4casestudy.model;

import huy.module4casestudy.model.Player;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "player_salaries")
public class PlayerSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    private Double baseSalary;
    private Double skillSalary;
    private Double bonus;
    private Integer hoursPlayed;
    private Double totalSalary;

    @Temporal(TemporalType.DATE)
    private Date salaryDate;

    // Tính tổng lương
    @PrePersist
    @PreUpdate
    public void calculateTotalSalary() {
        this.totalSalary = baseSalary + (skillSalary * hoursPlayed) + bonus;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(Double baseSalary) { this.baseSalary = baseSalary; }

    public Double getSkillSalary() { return skillSalary; }
    public void setSkillSalary(Double skillSalary) { this.skillSalary = skillSalary; }

    public Double getBonus() { return bonus; }
    public void setBonus(Double bonus) { this.bonus = bonus; }

    public Integer getHoursPlayed() { return hoursPlayed; }
    public void setHoursPlayed(Integer hoursPlayed) { this.hoursPlayed = hoursPlayed; }

    public Double getTotalSalary() { return totalSalary; }
    public Date getSalaryDate() { return salaryDate; }
}
