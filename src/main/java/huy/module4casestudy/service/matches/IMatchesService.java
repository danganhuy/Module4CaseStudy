package huy.module4casestudy.service.matches;

import huy.module4casestudy.model.Matches;
import huy.module4casestudy.service.IGenericService;

import java.util.List;

public interface IMatchesService extends IGenericService<Matches> {
    List<Matches> getMatchesByCoachId(Long coachId);
}
