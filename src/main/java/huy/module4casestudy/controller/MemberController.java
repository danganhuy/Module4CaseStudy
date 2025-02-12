package huy.module4casestudy.controller;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.service.member.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<?> getMember(){
        List<Member> members = memberService.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addMember(@RequestBody final Member member){
        memberService.save(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateMember(@RequestBody final Member member){
        if(memberService.findById(member.getId())==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberService.save(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id){
        Member member = memberService.findById(id);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberService.delete(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
