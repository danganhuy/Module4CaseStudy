package huy.module4casestudy.service.matchplayer;

import huy.module4casestudy.model.MatchPlayer;
import huy.module4casestudy.repository.IMatchPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchPlayerService implements IMatchPlayerService {
    @Autowired
    private IMatchPlayerRepository matchPlayerRepository;

    @Override
    public List<MatchPlayer> findAll() {
        return matchPlayerRepository.findAll();
    }

    @Override
    public Optional<MatchPlayer> findById(Long id) {
        return matchPlayerRepository.findById(id);
    }

    @Override
    public void save(MatchPlayer matchPlayer) {
        matchPlayerRepository.save(matchPlayer);
    }

    @Override
    public void delete(MatchPlayer matchPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
