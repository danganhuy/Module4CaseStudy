package huy.module4casestudy.model.DTO;

import huy.module4casestudy.model.MatchPlayer;
import huy.module4casestudy.model.Matches;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchPlayerDTO {
    private Long id;
    private String name;
    private LocalDateTime date;
    private String location;
    private Long teamId;
    private Long coachId;
    private Integer performanceRating;
    private String review;

    public MatchPlayerDTO(Matches matches, MatchPlayer matchPlayer) {
        this.id = matches.getId();
        this.name = matches.getName();
        this.date = matches.getDate();
        this.location = matches.getLocation();
        this.teamId = matches.getTeamId();
        this.coachId = matches.getCoachId();
        this.performanceRating = matchPlayer.getPerformanceRating();
        this.review = matchPlayer.getReview();
    }
}
