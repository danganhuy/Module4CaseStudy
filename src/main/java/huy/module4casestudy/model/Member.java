package huy.module4casestudy.model;


import com.fasterxml.jackson.databind.BeanProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 255)
    private String fullName;

    private LocalDate dateOfBirth;

    @Column(length = 255)
    private String nationality;

    @Column(length = 255)
    private String hometown;

    @Enumerated(EnumType.STRING)
    private EMemberType memberType;

}

