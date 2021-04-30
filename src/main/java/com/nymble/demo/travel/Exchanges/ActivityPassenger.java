package com.nymble.demo.travel.Exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityPassenger {
    private String destination;
    private String name;
    private float price;
}
