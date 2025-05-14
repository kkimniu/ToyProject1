package ToyProject.ToyProject1.controller;

import ToyProject.ToyProject1.domain.Member;
import ToyProject.ToyProject1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/login")
    public String login(Model model){
        model.addAttribute("data","hello!!");
        return "members/login";
    }
    @GetMapping("/members/signUp")
    public String createForm(){
        return "members/createMemberForm";
    }
    @GetMapping("/members/check")
    public String idCheckForm(){
        return "members/idCheckForm";
    }
    @GetMapping("/members/idCheck")
    public String idCheck(MemberForm form,Model model){
        Member member = new Member();
        member.setUserid(form.getUserid());
        boolean reuslt = memberService.findUserid(member);
        if(reuslt){
            model.addAttribute("msg",form.getUserid()+"사용불가능한 ID입니다");
            return "members/idCheckForm";
        }else {
            model.addAttribute("msg", "사용가능한 ID입니다");
            model.addAttribute("userid", form.getUserid());
            return "members/idCheckMsg";
        }
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setUserid(form.getUserid());
        member.setName(form.getName());
        member.setPwd(form.getPwd());
        member.setTel(form.getTel());
        member.setAddr(form.getAddr());
        member.setEmail(form.getEmail());
        member.setJoindate(LocalDateTime.now());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members/memberList")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }
}
