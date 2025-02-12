package huy.module4casestudy.service.matches;

import huy.module4casestudy.model.Matches;
import huy.module4casestudy.repository.IMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchesService implements IMatchesService {
    @Autowired
    private IMatchesRepository matchesRepository;

    @Override
    public List<Matches> findAll() {
        return matchesRepository.findAll();
    }

    @Override
    public Optional<Matches> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Matches matches) {

    }

    @Override
    public void delete(Matches matches) {

    }
}
