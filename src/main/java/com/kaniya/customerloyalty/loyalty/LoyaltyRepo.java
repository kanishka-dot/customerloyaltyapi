package com.kaniya.customerloyalty.loyalty;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyRepo extends JpaRepository<Loyalty,Integer> {
}
