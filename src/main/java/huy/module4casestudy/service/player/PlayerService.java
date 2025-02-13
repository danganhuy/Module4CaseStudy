package huy.module4casestudy.service.player;

import huy.module4casestudy.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

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
