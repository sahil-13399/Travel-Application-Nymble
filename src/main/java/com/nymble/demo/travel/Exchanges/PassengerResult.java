package com.nymble.demo.travel.Exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PassengerResult {

    private String passengerName;
    private String passengerNumber;
    private List<ActivityPassenger> passengerActivityList;
}
