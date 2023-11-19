package com.kaniya.customerloyalty.loyalty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoyaltyService {

    private final LoyaltyRepo loyaltyRepo;

    public LoyaltyResponse addLoyaltyPoints(LoyaltyRequest request) {

        Optional<Loyalty> loyaltyOpt = loyaltyRepo.findById(request.getId());
        LoyaltyResponse loayltyResponse = null;

        if(loyaltyOpt.isPresent()){
            Loyalty loyalty = loyaltyOpt.get();

            if(request.getPointAdd()>0){
                Double totalPoints = loyalty.getTotalpoints();
                totalPoints += request.getPointAdd();
                loyalty.setTotalpoints(totalPoints);
                loyaltyRepo.save(loyalty);

                loayltyResponse = LoyaltyResponse.builder()
                        .id(request.getId())
                        .totalPoints(totalPoints)
                        .totalRedeem(loyalty.getTotalredeem())
                        .updateStatus(true)
                        .remark("Customer loyalty point added")
                        .build();
            }else{
                loayltyResponse = LoyaltyResponse.builder()
                        .id(request.getId())
                        .totalPoints(0.00)
                        .totalRedeem(0.00)
                        .updateStatus(false)
                        .remark("Invalid point amount")
                        .build();
            }

        }else{// if customer is not found
            loayltyResponse = LoyaltyResponse.builder()
                    .id(request.getId())
                    .totalPoints(0.00)
                    .totalRedeem(0.00)
                    .updateStatus(false)
                    .remark("Customer not found")
                    .build();
        }
        return  loayltyResponse;

    }

    public LoyaltyResponse deductLoyaltyPoints(LoyaltyRequest request) {

        Optional<Loyalty> loyaltyOpt = loyaltyRepo.findById(request.getId());
        LoyaltyResponse loayltyResponse = null;

        if(loyaltyOpt.isPresent()){
            Loyalty loyalty = loyaltyOpt.get();
            // check current point balance is greater than request point deduction and red points greater than 0
            if(request.getPointDeduct()>0 &&
                    loyalty.getTotalpoints()-loyalty.getTotalredeem()>= request.getPointDeduct()){

                Double totalDeductPoints = loyalty.getTotalredeem();
                totalDeductPoints += request.getPointDeduct();
                loyalty.setTotalredeem(totalDeductPoints);
                loyaltyRepo.save(loyalty);

                loayltyResponse = LoyaltyResponse.builder()
                        .id(request.getId())
                        .totalPoints(loyalty.getTotalpoints())
                        .totalRedeem(totalDeductPoints)
                        .updateStatus(true)
                        .remark("Customer loyalty point deducted")
                        .build();

            }else{
                loayltyResponse = LoyaltyResponse.builder()
                        .id(request.getId())
                        .totalPoints(0.00)
                        .totalRedeem(0.00)
                        .updateStatus(false)
                        .remark("Invalid point amount")
                        .build();
            }

        }else{// if customer is not found
            loayltyResponse = LoyaltyResponse.builder()
                    .id(request.getId())
                    .totalPoints(0.00)
                    .totalRedeem(0.00)
                    .updateStatus(false)
                    .remark("Customer not found")
                    .build();
        }
        return  loayltyResponse;
    }
}
