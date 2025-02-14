package huy.module4casestudy.service.player;

import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService{
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();

    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void delete(Player player) {
        playerRepository.delete(player);
    }
}
