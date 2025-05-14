package ToyProject.ToyProject1.service;

import ToyProject.ToyProject1.domain.Member;
import ToyProject.ToyProject1.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**회원가입*/
    public String join(Member member){
        memberRepository.save(member);
        return member.getUserid();
    }

    public boolean findUserid(Member member){
        Optional<Member> result = memberRepository.findByUserId(member.getUserid());
        return result.isPresent();
    }
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberUserId){
        return memberRepository.findByUserId(memberUserId);
    }
}
