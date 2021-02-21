package com.x.pricingdemo;

import lombok.Getter;
import lombok.Setter;

/**
 * com.x.pricingdemo - ItemBean
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/
@Getter
@Setter
public class ItemResponse {

    private Long id;
    private String itemName;
    private Integer numOfItemInCarton;
    private Double cartonPrice;


}

