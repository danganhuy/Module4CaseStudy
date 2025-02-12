package huy.module4casestudy.controller;

import huy.module4casestudy.model.Matches;
import huy.module4casestudy.service.matches.IMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/matches")
@CrossOrigin("*")
public class MatchesController {
    @Autowired
    private IMatchesService matchesService;

    @GetMapping
    public ResponseEntity<?> getMatches() {
         List<Matches> matches = matchesService.findAll();
         return ResponseEntity.ok(matches);
    }
}
