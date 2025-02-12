package huy.module4casestudy.service.matches;

import huy.module4casestudy.model.Matches;
import huy.module4casestudy.repository.IMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesService implements IMatchesService{
    @Autowired
    private IMatchesRepository iMatchesRepository;
    @Override
    public List<Matches> findAll() {
        return iMatchesRepository.findAll();
    }

    @Override
    public Matches findById(Long id) {
        return iMatchesRepository.findById(id).orElse(null);
    }

    @Override
    public Matches save(Matches matches) {
        return iMatchesRepository.save(matches);
    }

    @Override
    public void delete(Matches matches) {
        iMatchesRepository.delete(matches);
    }
}
