package com.kaniya.customerloyalty.loyalty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyRequest {

    private Integer id;
    private double pointAdd;

    private double pointDeduct;

}
