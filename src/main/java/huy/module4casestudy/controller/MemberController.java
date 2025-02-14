package huy.module4casestudy.controller;


import huy.module4casestudy.model.DTO.MemberUpdateDTO;
import huy.module4casestudy.model.EMemberType;
import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.IMemberRepository;
import huy.module4casestudy.repository.IPlayerRepository;
import huy.module4casestudy.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private IMemberRepository memberRepository;

    @Autowired
    private IPlayerRepository playerRepository;

    @GetMapping("")
    public Iterable<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody MemberUpdateDTO updatedMember) {
        Optional<Member> memberOpt = memberService.findById(id);
        if (!memberOpt.isPresent()) {
            return ResponseEntity.notFound().build();

        }

        Member member = memberOpt.get();
        member.setFullName(updatedMember.getFullName());
        member.setDateOfBirth(updatedMember.getDateOfBirth());
        member.setNationality(updatedMember.getNationality());
        member.setHometown(updatedMember.getHometown());
        member.setMemberType(updatedMember.getMemberType());
        memberRepository.save(member); // Lưu member trước
        // Cập nhật hoặc xóa Player tùy theo loại thành viên
        if (updatedMember.getMemberType() == EMemberType.PLAYER) {
            Optional<Player> playerOpt = playerRepository.findById(id);
            Player player = playerOpt.orElse(new Player());

            player.setId(id); // Vì dùng @MapsId, Player phải có cùng ID với Member
            player.setMember(member);
            player.setHeight(updatedMember.getHeight());
            player.setWeight(updatedMember.getWeight());
            player.setBmi(updatedMember.getBmi());
            player.setRanking(updatedMember.getRanking());

            playerRepository.save(player); // Sau đó lưu player
        } else {
            // Nếu chuyển từ PLAYER sang COACH, xóa dữ liệu Player
            playerRepository.deleteById(id);
            memberRepository.save(member);
        }

        return ResponseEntity.ok("Cập nhật thành công!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<?> getMemberDetails(@PathVariable Long id) {
        Optional<Member> memberOpt = memberService.findById(id);
        if (!memberOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Member member = memberOpt.get();
        Optional<Player> playerOpt = memberService.findPlayerByMemberId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", member.getId());
        response.put("fullName", member.getFullName());
        response.put("dateOfBirth", member.getDateOfBirth());
        response.put("nationality", member.getNationality());
        response.put("hometown", member.getHometown());
        response.put("memberType", member.getMemberType());

        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            response.put("height", player.getHeight());
            response.put("weight", player.getWeight());
            response.put("bmi", player.getBmi());
            response.put("ranking", player.getRanking());
        }

        return ResponseEntity.ok(response);
    }
    @PostMapping("")
    public ResponseEntity<?> createMember(@RequestBody MemberUpdateDTO newMember) {
        if (newMember.getFullName() == null || newMember.getFullName().isEmpty()) {
            return ResponseEntity.badRequest().body("Họ và tên không được để trống!");
        }

        if (newMember.getMemberType() == null) {
            return ResponseEntity.badRequest().body("Loại thành viên không hợp lệ!");
        }
        Member member = new Member();
        member.setFullName(newMember.getFullName());
        member.setDateOfBirth(newMember.getDateOfBirth());
        member.setNationality(newMember.getNationality());
        member.setHometown(newMember.getHometown());
        member.setMemberType(newMember.getMemberType());

        member = memberRepository.save(member);
//        memberRepository.save(member);

        if (newMember.getMemberType() == EMemberType.PLAYER) {
            Player player = new Player();
            player.setId(member.getId()); // ID trùng với Member (dùng @MapsId)
            player.setMember(member);
            player.setHeight(newMember.getHeight() != null ? newMember.getHeight() : BigDecimal.ZERO);
            player.setWeight(newMember.getWeight() != null ? newMember.getWeight() : BigDecimal.ZERO);
            player.setBmi(newMember.getBmi() != null ? newMember.getBmi() : BigDecimal.ZERO);
            player.setRanking(newMember.getRanking() != null ? newMember.getRanking() : 0);

            playerRepository.save(player);
        }

        return ResponseEntity.ok("Thành viên được tạo thành công!");
    }

}
