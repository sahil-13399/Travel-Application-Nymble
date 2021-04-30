package com.nymble.demo.travel.Exchanges;

import lombok.Data;

import java.util.List;

@Data
public class PassengerResult {
    private String passengerName;
    private int passengerNumber;
    private List<ActivityPassenger> passengerActivityList;
}
