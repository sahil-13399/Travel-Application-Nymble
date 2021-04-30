package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PassengerList {
   private String packageName;
   private int packageCapacity;
   private int passengerCount;
   private List<Passenger> passengerList;
}
