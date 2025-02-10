package huy.module4casestudy.controller;

import huy.module4casestudy.model.Player;
import huy.module4casestudy.model.PlayerSalary;
import huy.module4casestudy.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerDetails(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/{id}/salaries")
    public ResponseEntity<Map<String, Object>> getPlayerSalaries(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        List<String> salaryWeeks = new ArrayList<>();
        List<Double> salaryValues = new ArrayList<>();

        for (PlayerSalary salary : player.getSalaries()) {
            salaryWeeks.add(salary.getSalaryDate().toString());
            salaryValues.add(salary.getTotalSalary());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("salaryWeeks", salaryWeeks);
        response.put("salaryValues", salaryValues);

        return ResponseEntity.ok(response);
    }
}