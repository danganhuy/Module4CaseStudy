package huy.module4casestudy.service.member;


import huy.module4casestudy.model.Member;
import huy.module4casestudy.repository.IMemberRepository;
import huy.module4casestudy.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberService implements IMemberService{
    @Autowired
    private IMemberRepository memberRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void save(Member member) {
         memberRepository.save(member);
    }


    @Override
    public void deleteById(Long memberId) {
        userRepository.deleteById(memberId); // Xóa user trước
        memberRepository.deleteById(memberId); // Sau đó xóa member
    }


}
