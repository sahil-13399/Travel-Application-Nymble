package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.ActivityPassenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PassengerResult {

    private String passengerName;
    private String passengerNumber;
    private float balance;
    private List<ActivityPassenger> passengerActivityList;
}
