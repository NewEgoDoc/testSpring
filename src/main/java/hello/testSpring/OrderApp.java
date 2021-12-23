package hello.testSpring;

import hello.testSpring.member.Grade;
import hello.testSpring.member.Member;
import hello.testSpring.member.MemberService;
import hello.testSpring.member.MemberServiceImpl;
import hello.testSpring.order.Order;
import hello.testSpring.order.OrderService;
import hello.testSpring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
