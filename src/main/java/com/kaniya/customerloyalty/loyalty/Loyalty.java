package com.kaniya.customerloyalty.loyalty;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaniya.customerloyalty.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loyalty")
public class Loyalty {


    @Id
    private Integer custid;
    private Double totalpoints;

    private Double totalredeem;

    @OneToOne
    @MapsId
    @JoinColumn(name = "custid")
    @JsonIgnore
    private Customer customer;

}
