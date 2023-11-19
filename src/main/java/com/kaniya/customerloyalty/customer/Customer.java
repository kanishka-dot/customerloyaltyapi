package com.kaniya.customerloyalty.customer;


import com.kaniya.customerloyalty.loyalty.Loyalty;
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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Loyalty loyalty;
}
