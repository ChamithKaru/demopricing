package com.x.pricingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.x.pricingdemo - PricingServiceImpl
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/

@Service
public class PricingServiceImpl implements PricingService{

    @Autowired
    ItemRepository itemRepository;

    @Value("${com.x.kds.pricingdemo.singleUnit.priceMultiplier}") //1.3
    private Double priceMultiplier;

    @Value("${com.x.kds.pricingdemo.discount.minCartonsRequired}") //3
    private Double minCartonsRequired;

    @Value("${com.x.kds.pricingdemo.discount.discountMultiplier}") //0.9
    private Double discountMultiplier;

    @Override
    public Double calculateTotalPrice(List<PricingRequest> pricingRequestList) throws Exception {
        Double totalPrice = 0.0;
        for (PricingRequest pricingRequest : pricingRequestList){
            Double totalItemPrice = 0.0;
            Integer numOfCartons = 0;
            Integer singleUnitsOfItem = 0;
            Item item = itemRepository.findById(pricingRequest.getItemId()).orElseThrow(() -> new Exception("Pricing Error || No Item found for the id : " + pricingRequest.getItemId()));
            numOfCartons = pricingRequest.getNumOfItem() / item.getNumOfItemInCarton();
            singleUnitsOfItem = pricingRequest.getNumOfItem() % item.getNumOfItemInCarton();
            totalItemPrice = (singleUnitsOfItem * (item.getCartonPrice()/item.getNumOfItemInCarton()) * priceMultiplier);
            totalItemPrice = totalItemPrice + ((numOfCartons >= minCartonsRequired) ? ((numOfCartons * item.getCartonPrice()) * discountMultiplier) : (numOfCartons * item.getCartonPrice()));
            totalPrice = totalPrice + totalItemPrice;
        }

        return totalPrice;
    }
}

