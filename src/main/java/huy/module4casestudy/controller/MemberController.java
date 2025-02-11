package huy.module4casestudy.controller;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin("*") // Cho phép gọi API từ frontend
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public Iterable<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> getCoachById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.ok("Member deleted successfully!");
    }
}
