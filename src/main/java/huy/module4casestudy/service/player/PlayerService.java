package huy.module4casestudy.service.player;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.IPlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerService implements IPlayerService {

    @Autowired
    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public List<Member> getAllPlayers() {
        return playerRepository.findAllMembers();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + id));
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Long id, Player playerDetails) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setHeight(playerDetails.getHeight());
        existingPlayer.setWeight(playerDetails.getWeight());
        existingPlayer.setBmi(playerDetails.getBmi());
        existingPlayer.setRanking(playerDetails.getRanking());
        existingPlayer.setCoach(playerDetails.getCoach());
        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }
    @Override
    public List<Member> getAllMembers() {
        return playerRepository.findAllMembers();
    }

    @Override
    public Player getPlayerDetails(Long id) {
        return playerRepository.findPlayerDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + id));
    }
}

