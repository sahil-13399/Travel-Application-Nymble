package com.nymble.demo.travel.Exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityPassenger {
    private String destination;
    private String name;
    private float price;
}
