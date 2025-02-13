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
    private IPlayerRepository iPlayerRepository;

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        return iPlayerRepository.findAllByTeamId(teamId);
    }
    @Override
    public List<Player> findAll() {
        return List.of();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Player player) {

    }

    @Override
    public void delete(Player player) {

    }
}
