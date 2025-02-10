package huy.module4casestudy.model;

import huy.module4casestudy.model.composite.MatchPlayerId;
import jakarta.persistence.*;

@Entity
@Table(name = "match_player")
public class MatchPlayer {
    @EmbeddedId
    private MatchPlayerId id;

    private Integer performanceRating;

    @Column(columnDefinition = "TEXT")
    private String review;
}
