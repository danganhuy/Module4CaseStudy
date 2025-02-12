package huy.module4casestudy.service.team;

import huy.module4casestudy.model.Team;
import huy.module4casestudy.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements ITeamService{
    @Autowired
    private ITeamRepository iTeamRepository;

    @Override
    public List<Team> findAll() {
        return iTeamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return iTeamRepository.findById(id);
    }

    @Override
    public void save(Team team) {
        iTeamRepository.save(team);
    }

    @Override
    public void delete(Team team) {
        iTeamRepository.delete(team);
    }
}
