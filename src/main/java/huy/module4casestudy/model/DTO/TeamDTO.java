package huy.module4casestudy.model.DTO;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Team;
import lombok.Data;

@Data
public class TeamDTO {
    private String name;
    private String description;
    private String coachName;
    private Integer playerCount;

    public TeamDTO(Team team, Member member, Integer playerCount) {
        this.name = team.getName();
        this.description = team.getDescription();
        this.coachName = member.getFullName();
        this.playerCount = playerCount;
    }
}
