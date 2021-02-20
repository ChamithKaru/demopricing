package com.x.pricingdemo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.x.pricingdemo - ItemRepository
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/

public interface ItemRepository extends JpaRepository<Item, Long> {
}


