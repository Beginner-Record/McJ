package com.record.mcj.data;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    String zipcode, city, street;


    public Address(String zipcode, String city, String street) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }
}
