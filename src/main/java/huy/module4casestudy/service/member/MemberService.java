package huy.module4casestudy.service.member;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.IMemberRepository;
import huy.module4casestudy.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberService implements IMemberService {
    @Autowired
    private IMemberRepository memberRepository;

    @Autowired
    private IPlayerRepository playerRepository;

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
    public void deleteById(Long id) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        playerOpt.ifPresent(playerRepository::delete); // Xóa Player trước nếu có

        memberRepository.deleteById(id); // Xóa Member
    }
    public Optional<Player> findPlayerByMemberId(Long memberId) {
        return playerRepository.findById(memberId);
    }
}
