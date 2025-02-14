package huy.module4casestudy.model.DTO;

import huy.module4casestudy.model.EMemberType;
import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.model.composite.EStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MemberUpdateDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String hometown;
    private EMemberType memberType;
    private String avatar;

    // Dữ liệu của Player (chỉ khi memberType là PLAYER)
    private BigDecimal height;
    private BigDecimal weight;
    private BigDecimal bmi;
    private Integer ranking;
    private EStatus status;
    private Long teamId;

    public MemberUpdateDTO(Member member, Player player) {
        fullName = member.getFullName();
        dateOfBirth = member.getDateOfBirth();
        nationality = member.getNationality();
        hometown = member.getHometown();
        memberType = member.getMemberType();
        avatar = member.getFileName();

        height = player.getHeight();
        weight = player.getWeight();
        bmi = player.getBmi();
        ranking = player.getRanking();
        status = player.getStatus();
        teamId = player.getTeamId();
    }
}