package com.x.pricingdemo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.x.pricingdemo - PricingService
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/

public interface PricingService {

    Double calculateTotalPrice(List<PricingRequest> list) throws Exception;
}


