package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TravelPackage {
    private int packageId;
    private String packageName;
    private int packageCapacity;
    private List<Destination> packageDestinations;
    private List<Passenger> packagePassenger;
}
