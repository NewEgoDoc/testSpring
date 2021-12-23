package hello.testSpring;

import hello.testSpring.discount.DiscountPolicy;
import hello.testSpring.discount.FixDiscountPolicy;
import hello.testSpring.discount.RateDiscountPolicy;
import hello.testSpring.member.MemberService;
import hello.testSpring.member.MemberServiceImpl;
import hello.testSpring.member.MemoryMemberRepository;
import hello.testSpring.order.OrderService;
import hello.testSpring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
