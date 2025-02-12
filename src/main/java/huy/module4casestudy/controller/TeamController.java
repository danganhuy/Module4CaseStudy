package huy.module4casestudy.controller;

import huy.module4casestudy.model.Team;
import huy.module4casestudy.service.team.ITeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/team")
@CrossOrigin("*")
public class TeamController {
    private final ITeamService teamService;

    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
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
