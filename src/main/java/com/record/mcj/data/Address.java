package com.record.mcj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Address {

    String zipcode, city, street;

    public Address(String zipcode, String city, String street) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }
}
