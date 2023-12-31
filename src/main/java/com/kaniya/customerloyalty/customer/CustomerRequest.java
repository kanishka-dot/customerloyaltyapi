package com.kaniya.customerloyalty.customer;


import com.kaniya.customerloyalty.loyalty.Loyalty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String firstname;

    private String lastname;

    private String address;

    private Loyalty loyalty;

}
