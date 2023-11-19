package com.kaniya.customerloyalty.loyalty;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loyalty/api/v1")
@RequiredArgsConstructor
public class LoyaltyControler {

    private  final  LoyaltyService loyaltyService;

    @PostMapping("/addLoyaltyPoints")
    public LoyaltyResponse addLoyaltyPoints(@RequestBody LoyaltyRequest request){
        return loyaltyService.addLoyaltyPoints(request);
    }

    @PostMapping("/deductLoyaltyPoints")
    public LoyaltyResponse deductLoyaltyPoints(@RequestBody LoyaltyRequest request){
        return loyaltyService.deductLoyaltyPoints(request);
    }


}
