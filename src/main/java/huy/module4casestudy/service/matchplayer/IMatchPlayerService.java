package huy.module4casestudy.service.matchplayer;

import huy.module4casestudy.model.MatchPlayer;
import huy.module4casestudy.model.Matches;
import huy.module4casestudy.service.IGenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMatchPlayerService extends IGenericService<MatchPlayer> {
    List<MatchPlayer> findMatchesByPlayerId(Long id);
}
