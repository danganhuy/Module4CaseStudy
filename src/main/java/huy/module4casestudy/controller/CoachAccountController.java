package huy.module4casestudy.controller;

import huy.module4casestudy.model.*;
import huy.module4casestudy.model.DTO.CoachDTO;
import huy.module4casestudy.model.DTO.TeamDTO;
import huy.module4casestudy.service.coach.ICoachService;
import huy.module4casestudy.service.matches.IMatchesService;
import huy.module4casestudy.service.matchplayer.IMatchPlayerService;
import huy.module4casestudy.service.member.IMemberService;
import huy.module4casestudy.service.player.IPlayerService;
import huy.module4casestudy.service.salary.ISalaryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachAccountController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private ICoachService coachService;
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private ISalaryService salaryService;
    @Autowired
    private IMatchesService IMatchesService;

    @GetMapping("/details")
    public ResponseEntity<?> getDetails(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        Coach coach = coachService.findById(id).get();
        CoachDTO coachDetails = new CoachDTO(coach.getMember(), coach);
        return ResponseEntity.ok(coachDetails);
    }

    @GetMapping("/team")
    public ResponseEntity<?> getTeam(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        Coach coach = coachService.findById(id).get();
        Team team = coach.getTeam();
        Integer playerCount = playerService.getPlayerCountByTeamId(team.getId());
        TeamDTO teamDTO = new TeamDTO(team, coach.getMember(), playerCount);
        return ResponseEntity.ok(teamDTO);
    }

    @GetMapping("/listPlayer")
    public ResponseEntity<?> getListPlayer(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        Coach coach = coachService.findById(id).get();
        List<Player> playerList = playerService.getPlayersByTeamId(coach.getTeam().getId());
        return ResponseEntity.ok(playerList);
    }

    @GetMapping("/listSalary")
    public ResponseEntity<?> getListSalary(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        Member member = memberService.findById(id).get();
        List<Salary> salaryList = salaryService.getSalariesById(id);
        return ResponseEntity.ok(salaryList);
    }
}
