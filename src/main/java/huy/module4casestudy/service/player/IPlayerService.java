package huy.module4casestudy.service.player;

import huy.module4casestudy.model.Player;
import huy.module4casestudy.service.IGenericService;


import java.util.List;

public interface IPlayerService extends IGenericService<Player> {
    List<Player> getPlayersByTeamId(Long teamId);



