package huy.module4casestudy.model;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
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
}
