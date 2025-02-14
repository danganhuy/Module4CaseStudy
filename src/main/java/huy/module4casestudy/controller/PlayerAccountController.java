package huy.module4casestudy.controller;

import huy.module4casestudy.model.*;
import huy.module4casestudy.model.DTO.MatchPlayerDTO;
import huy.module4casestudy.model.DTO.MemberUpdateDTO;
import huy.module4casestudy.service.matches.IMatchesService;
import huy.module4casestudy.service.matchplayer.IMatchPlayerService;
import huy.module4casestudy.service.member.IMemberService;
import huy.module4casestudy.service.player.IPlayerService;
import huy.module4casestudy.service.salary.ISalaryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin("*")
public class PlayerAccountController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private ISalaryService salaryService;
    @Autowired
    private IMatchPlayerService matchPlayerService;

    @GetMapping("/details")
    public ResponseEntity<?> getPlayerDetails(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        Member member = memberService.findById(id).get();
        Player player = playerService.findById(id).get();
        MemberUpdateDTO memberDetails = new MemberUpdateDTO(member, player);
        return ResponseEntity.ok(memberDetails);
    }

    @GetMapping("/salaries")
    public ResponseEntity<?> getSalaries(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        List<Salary> salaries = salaryService.getSalariesById(id);
        return ResponseEntity.ok(salaries);
    }

    @GetMapping("/matches")
    public ResponseEntity<?> getMatches(HttpServletRequest request) {
        Long id = Long.parseLong(request.getAttribute("id").toString());
        List<MatchPlayer> matchPlayers = matchPlayerService.findMatchesByPlayerId(id);
//        List<Matches> matches = matchesService.findAll();
        List<MatchPlayerDTO> matches = new ArrayList<>();
        for (MatchPlayer matchPlayer : matchPlayers) {
            matches.add(new MatchPlayerDTO(matchPlayer.getId().getMatches(), matchPlayer));
        }
        return ResponseEntity.ok(matches);
    }
}
