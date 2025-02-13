package huy.module4casestudy.controller;

import huy.module4casestudy.model.Player;
import huy.module4casestudy.model.Team;
import huy.module4casestudy.service.player.IPlayerService;
import huy.module4casestudy.service.team.ITeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/team")
@CrossOrigin("*")
public class TeamController {
    private final ITeamService teamService;
    private final IPlayerService playerService;

    public TeamController(ITeamService teamService, IPlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }
    @GetMapping(value = "/{teamId}/players",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPlayersByTeam(@PathVariable Long teamId) {
        List<Player> players = playerService.getPlayersByTeamId(teamId);
        System.out.println(players);
        if (players.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(players);
        }
        return ResponseEntity.ok(players);
    }
    @GetMapping
    public ResponseEntity<?> getTeam(){
        List<Team> teams = teamService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addTeam(@RequestBody final Team team){
        teamService.save(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateTeam(@RequestBody final Team team){
        if(teamService.findById(team.getId())==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teamService.save(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id){
        Optional<Team> team = teamService.findById(id);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teamService.delete(team.get());
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
