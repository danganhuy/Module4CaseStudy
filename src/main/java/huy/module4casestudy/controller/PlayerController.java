package huy.module4casestudy.controller;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.service.player.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


//    @GetMapping
//    public ResponseEntity<List<Map<String, Object>>> getAllPlayers() {
//        List<Member> players = playerService.getAllPlayers();
//
//        List<Map<String, Object>> response = players.stream().map(player -> {
//            Map<String, Object> playerData = new HashMap<>();
//            playerData.put("id", player.getId());
//            playerData.put("fullName", player.getMember().getFullName());
//            playerData.put("yearOfBirth", player.getMember().getDateOfBirth().getYear());
//            playerData.put("hometown", player.getMember().getHometown());
//            playerData.put("ranking", player.getRanking());
//            playerData.put("position", "Unknown"); // Thêm thông tin vị trí chơi nếu có
//            return playerData;
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
//        return ResponseEntity.ok(playerService.getPlayerById(id));
//    }

    // Danh sách chỉ gồm thông tin Member
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllPlayers() {
        List<Member> members = playerService.getAllMembers();

        List<Map<String, Object>> response = members.stream().map(member -> {
            Map<String, Object> memberData = new HashMap<>();
            memberData.put("id", member.getId());
            memberData.put("fullName", member.getFullName());
            memberData.put("yearOfBirth", member.getDateOfBirth().getYear());
            memberData.put("hometown", member.getHometown());
            return memberData;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // Lấy chi tiết Player + Member
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerDetails(id));
    }
}
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
        return ResponseEntity.ok(playerService.updatePlayer(id, playerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}

