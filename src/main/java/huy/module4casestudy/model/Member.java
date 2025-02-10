package huy.module4casestudy.model;


import com.fasterxml.jackson.databind.BeanProperty;
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

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public EMemberType getMemberType() {
        return memberType;
    }

    public Member getMember() {
        return null;
    }

    public Object getRanking() {
        return null;
    }
}

