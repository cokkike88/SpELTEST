package com.omunoz.SpELTest.services;

import com.omunoz.SpELTest.controllers.Order;
import com.omunoz.SpELTest.entities.DiscountRule;
import com.omunoz.SpELTest.repositories.DiscountRuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DiscountService {
    private DiscountRuleRepository discountRuleRepository;

    public double calculateDiscount(Order order) {
        List<DiscountRule> discountRules = discountRuleRepository.findAll();
        double totalDiscount = 0;

        ExpressionParser parser = new SpelExpressionParser();
        for (DiscountRule discountRule : discountRules) {
            StandardEvaluationContext context = new StandardEvaluationContext(order);
            boolean isMatch = parser.parseExpression(discountRule.getCondition()).getValue(context, Boolean.class);
            if (isMatch) {
                totalDiscount += order.getTotalAmount() + (discountRule.getDiscountPercentage() / 100);
            }
        }
        return totalDiscount;
    }
}
