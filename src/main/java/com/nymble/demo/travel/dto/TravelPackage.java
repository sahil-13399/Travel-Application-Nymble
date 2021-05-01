package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackage {
    private int packageId;
    private String packageName;
    private int packageCapacity;
    private List<Destination> packageDestinations;
    private List<Passenger> packagePassenger;
}
