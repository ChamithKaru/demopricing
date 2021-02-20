package com.x.pricingdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * com.x.pricingdemo - PricingController
 *
 * @author : Chamith Karunakalage
 * @since : Feb 20, 2021
 **/

@RestController
@RequestMapping(value = "/demopricing/")
@Slf4j
public class PricingController {

    @Autowired
    PricingService pricingService;

    @GetMapping(value = "/calculateTotal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllItems(@RequestBody List<PricingRequest> itemDeliveryBeanList) throws JsonProcessingException {

        log.info("CalculateTotal Price :");
        String calculateTotalRequest = new ObjectMapper().writeValueAsString(itemDeliveryBeanList);
        log.info("CalculateTotal Price request : {}", calculateTotalRequest);
        try {

            Double totalPrice = pricingService.calculateTotalPrice(itemDeliveryBeanList);
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error :: ", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}

