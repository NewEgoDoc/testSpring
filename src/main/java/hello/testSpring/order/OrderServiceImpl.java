package hello.testSpring.order;

import hello.testSpring.discount.DiscountPolicy;
import hello.testSpring.discount.FixDiscountPolicy;
import hello.testSpring.member.Member;
import hello.testSpring.member.MemberRepository;
import hello.testSpring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
