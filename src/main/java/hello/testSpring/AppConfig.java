package hello.testSpring;

import hello.testSpring.discount.DiscountPolicy;
import hello.testSpring.discount.FixDiscountPolicy;
import hello.testSpring.discount.RateDiscountPolicy;
import hello.testSpring.member.MemberService;
import hello.testSpring.member.MemberServiceImpl;
import hello.testSpring.member.MemoryMemberRepository;
import hello.testSpring.order.OrderService;
import hello.testSpring.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
