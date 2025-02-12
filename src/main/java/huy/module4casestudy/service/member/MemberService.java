package huy.module4casestudy.service.member;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements IMemberService{
    @Autowired
    private IMemberRepository iMemberRepository;

    @Override
    public List<Member> findAll() {
        return iMemberRepository.findAll();
    }

    @Override
    public Member findById(Long id) {
        return iMemberRepository.findById(id).orElse(null);
    }

    @Override
    public Member save(Member member) {
        return iMemberRepository.save(member);
    }

    @Override
    public void delete(Member member) {
        iMemberRepository.delete(member);
    }
}
