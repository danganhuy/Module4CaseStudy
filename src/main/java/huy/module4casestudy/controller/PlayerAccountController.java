package huy.module4casestudy.controller;

import huy.module4casestudy.service.coach.ICoachService;
import huy.module4casestudy.service.member.IMemberService;
import huy.module4casestudy.service.player.IPlayerService;
import huy.module4casestudy.service.salary.ISalaryService;
import huy.module4casestudy.service.team.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ITeamService teamService;
    @Autowired
    private ICoachService coachService;
}
