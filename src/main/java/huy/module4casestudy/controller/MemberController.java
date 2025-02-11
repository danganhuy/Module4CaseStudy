package huy.module4casestudy.controller;


import huy.module4casestudy.model.Member;
import huy.module4casestudy.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/members")

public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public Iterable<Member> getAllMembers() {
        return memberService.findAll();
    }
}
