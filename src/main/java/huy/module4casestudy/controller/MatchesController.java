package huy.module4casestudy.controller;

import huy.module4casestudy.model.Matches;
import huy.module4casestudy.service.matches.IMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/matches")
@CrossOrigin("*")
public class MatchesController {

    private final IMatchesService matchesService;

    public MatchesController(IMatchesService matchesService){
        this.matchesService=matchesService;
    }


    @GetMapping
    public ResponseEntity<?> getMatches(){
        List<Matches> matches = matchesService.findAll();
        return new ResponseEntity<>(matches, HttpStatus.OK);
        //return matches.toString();
    }
    @PostMapping
    public ResponseEntity<?> addMatches(@RequestBody final Matches matches){
        matchesService.save(matches);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateMatches(@RequestBody final Matches matches){
        if(matchesService.findById(matches.getId())==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        matchesService.save(matches);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatches(@PathVariable Long id){
        Optional<Matches> matches = matchesService.findById(id);
        if(matches == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        matchesService.delete(matches.get());
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
}
