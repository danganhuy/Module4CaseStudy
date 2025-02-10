package huy.module4casestudy.service;

import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }
}
