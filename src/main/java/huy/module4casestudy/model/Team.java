package huy.module4casestudy.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
