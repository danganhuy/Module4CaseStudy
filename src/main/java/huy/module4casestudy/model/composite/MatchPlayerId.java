package huy.module4casestudy.model.composite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import huy.module4casestudy.model.Matches;
import huy.module4casestudy.model.Player;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class MatchPlayerId implements Serializable {
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "match_id")
    private Long matchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId
//    @JoinColumn(name = "match_id")
//    @JsonBackReference
//    private Matches matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchPlayerId that = (MatchPlayerId) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(matchId, that.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId,matchId);
    }
}
