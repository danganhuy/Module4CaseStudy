package huy.module4casestudy.controller;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.model.Member;
import huy.module4casestudy.service.coach.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    private CoachService coachService;

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coach> getCoachById(@PathVariable Long id) {
        return coachService.findById(id);
    }
//    @PostMapping
//    public Member createCoach(@RequestBody Coach coach) {
//        coachService.save(coach);
//    }
}
