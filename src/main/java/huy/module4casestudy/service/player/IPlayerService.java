package huy.module4casestudy.service.player;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;

import java.util.List;

public interface IPlayerService {
    List<Member> getAllPlayers();
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
    Player updatePlayer(Long id, Player playerDetails);
    void deletePlayer(Long id);
    List<Member> getAllMembers();
    Player getPlayerDetails(Long id);
}

