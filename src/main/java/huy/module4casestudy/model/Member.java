package huy.module4casestudy.model;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public EMemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(EMemberType memberType) {
        this.memberType = memberType;
    }
}
