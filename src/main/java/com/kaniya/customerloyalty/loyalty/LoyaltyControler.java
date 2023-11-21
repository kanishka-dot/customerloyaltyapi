package com.kaniya.customerloyalty.loyalty;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loyalty/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
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
