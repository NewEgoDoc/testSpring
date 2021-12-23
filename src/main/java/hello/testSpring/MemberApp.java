package hello.testSpring;

import hello.testSpring.member.Grade;
import hello.testSpring.member.Member;
import hello.testSpring.member.MemberService;
import hello.testSpring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {//psvm
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);//Ctrl+Alt+V
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
