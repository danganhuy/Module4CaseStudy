package huy.module4casestudy.controller;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.service.coach.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coaches")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        return ResponseEntity.ok(coachService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Coach>> getCoachById(@PathVariable Long id) {
        return ResponseEntity.ok(coachService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach newCoach = coachService.save(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCoach);
    }
}
