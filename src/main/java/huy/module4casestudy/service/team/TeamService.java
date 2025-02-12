package huy.module4casestudy.service.team;

import huy.module4casestudy.model.Team;
import huy.module4casestudy.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService{
    @Autowired
    private ITeamRepository iTeamRepository;

    @Override
    public List<Team> findAll() {
        return iTeamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return iTeamRepository.findById(id).orElse(null);
    }

    @Override
    public Team save(Team team) {
        iTeamRepository.save(team);
        return team;
    }

    @Override
    public void delete(Team team) {
        iTeamRepository.delete(team);
    }
}
