package com.record.mcj.data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {

    String zipcode, city, street;


}
