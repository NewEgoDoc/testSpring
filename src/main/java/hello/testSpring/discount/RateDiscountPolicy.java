package hello.testSpring.discount;

import hello.testSpring.member.Grade;
import hello.testSpring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        } else {
            return 0;
        }
        //Ctrl + Shift + T ====> Test 만들기
    }
}
