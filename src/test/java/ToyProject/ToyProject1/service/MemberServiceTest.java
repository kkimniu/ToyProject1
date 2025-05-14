package ToyProject.ToyProject1.service;

import ToyProject.ToyProject1.domain.Member;
import ToyProject.ToyProject1.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setUserid("rlaehdals");
        member.setPwd("1234");
        member.setName("spring");
        member.setEmail("11111");
        member.setTel("1111");
        member.setAddr("서울");
        //when
        String saveUserId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveUserId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}