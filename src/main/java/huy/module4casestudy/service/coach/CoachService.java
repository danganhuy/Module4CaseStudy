package huy.module4casestudy.service.coach;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.repository.ICoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService implements ICoachService{
    @Autowired
    private ICoachRepository iCoachRepository;

    @Override
    public List<Coach> findAll() {
        return iCoachRepository.findAll();
    }

    @Override
    public Optional<Coach> findById(Long id) {
        return iCoachRepository.findById(id);
    }

    @Override
    public void save(Coach coach) {
        iCoachRepository.save(coach);
    }

    @Override
    public void delete(Coach coach) {
        iCoachRepository.delete(coach);
    }
}
