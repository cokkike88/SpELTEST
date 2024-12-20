package com.omunoz.SpELTest.repositories;

import com.omunoz.SpELTest.entities.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Long> {
}
