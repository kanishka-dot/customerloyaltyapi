package com.kaniya.customerloyalty.loyalty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyResponse {

    private Integer id;
    private Double totalPoints;
    private Double totalRedeem;
    private boolean updateStatus;
    private String remark;

}
