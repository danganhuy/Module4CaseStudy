package huy.module4casestudy.model.DTO;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.model.EMemberType;
import huy.module4casestudy.model.Member;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CoachDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String hometown;
    private EMemberType memberType;

    private Long teamId;

    public CoachDTO(Member member, Coach coach) {
        fullName = member.getFullName();
        dateOfBirth = member.getDateOfBirth();
        nationality = member.getNationality();
        hometown = member.getHometown();
        memberType = member.getMemberType();

        teamId = coach.getTeamId();
    }
}
