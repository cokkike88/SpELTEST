package com.omunoz.SpELTest.components;

import com.omunoz.SpELTest.entities.DiscountRule;
import com.omunoz.SpELTest.repositories.DiscountRuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final DiscountRuleRepository discountRuleRepository;

    @Override
    public void run(String... args) throws Exception {
        discountRuleRepository.saveAll(Arrays.asList(
                new DiscountRule("customerAge > 60", 10),
                new DiscountRule("membershipLevel == 'GOLD'", 15),
                new DiscountRule("membershipLevel == 'SILVER'", 5),
                new DiscountRule("totalAmount > 100", 20)
        ));
    }
}
