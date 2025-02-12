package huy.module4casestudy.controller;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.service.coach.ICoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
@CrossOrigin("*")
public class CoachController {
    private final ICoachService coachService;

    public CoachController(ICoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<?> getCoach(){
        List<Coach> coaches = coachService.findAll();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addCoach(@RequestBody final Coach coach){
        coachService.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateCoach(@RequestBody final Coach coach){
        if(coachService.findById(coach.getId())==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable Long id){
        Coach coach = coachService.findById(id);
        if(coach == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.delete(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }
}
