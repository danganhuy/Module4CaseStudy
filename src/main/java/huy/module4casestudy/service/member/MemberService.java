//package huy.module4casestudy.service.member;
//
//import huy.module4casestudy.model.Member;
//import huy.module4casestudy.repository.IMemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//public class MemberService implements IMemberService{
//    @Autowired
//    private IMemberRepository iMemberRepository;
//
//    @Override
//    public Iterable<Member> findAll() {
//        return iMemberRepository.findAll();
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return iMemberRepository.findById(id);
//    }
//
//    @Override
//    public Member save(Member member) {
//        return iMemberRepository.save(member);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        iMemberRepository.deleteById(id);
//
//    }
//}
