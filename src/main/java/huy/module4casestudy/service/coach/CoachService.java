package huy.module4casestudy.service.coach;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.repository.ICoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService implements ICoachService{
    @Autowired
    private ICoachRepository iCoachRepository;

    @Override
    public List<Coach> findAll() {
        return iCoachRepository.findAll();
    }

    @Override
    public Coach findById(Long id) {
        return iCoachRepository.findById(id).orElse(null);
    }

    @Override
    public Coach save(Coach coach) {
        iCoachRepository.save(coach);
        return coach;
    }

    @Override
    public void delete(Coach coach) {
        iCoachRepository.delete(coach);
    }
}
