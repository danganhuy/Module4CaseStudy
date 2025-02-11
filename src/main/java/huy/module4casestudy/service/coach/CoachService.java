package huy.module4casestudy.service.coach;

import huy.module4casestudy.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import huy.module4casestudy.repository.ICoachRepository;

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
    public Coach save(Coach coach) {
        return iCoachRepository.save(coach);
    }

    @Override
    public void deleteById(Long id) {
        iCoachRepository.deleteById(id);

    }


}
