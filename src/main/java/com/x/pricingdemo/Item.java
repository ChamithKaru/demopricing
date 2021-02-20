package com.x.pricingdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * com.x.pricingdemo - Item
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Integer numOfItemInCarton;
    private Double cartonPrice;
}

