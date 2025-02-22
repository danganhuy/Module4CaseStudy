package huy.module4casestudy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String fullName;

    private LocalDate dateOfBirth;

    @Column(length = 255)
    private String nationality;

    @Column(length = 255)
    private String hometown;

    @Enumerated(EnumType.STRING)
    private EMemberType memberType;

    @Column(length = 255)
    private String fileName;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private Player player;


}

