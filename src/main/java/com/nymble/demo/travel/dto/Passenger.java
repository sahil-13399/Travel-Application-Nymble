/**
 <h1>Passenger Class</h1>
 Contains the variables and
 methods of Passenger class

 @param passengerId : type int
 @param passengerName : type String
 @param passengerNumber : type String
 @param passengerCategory : type String
 @param balance : type float
 @param activityPassengerList : type List<ActivityPassenger>

  * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.dto;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Passenger {
    private int passengerId;
    private String passengerName;
    private String passengerNumber;
    private String passengerCategory;

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    private float balance;
    private List<ActivityPassenger> activityPassengerList;

    public Passenger(int passengerId, String passengerName, String passengerCategory, int balance) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerCategory = passengerCategory;
        this.balance = balance;
    }

    public List<ActivityPassenger> getActivityPassengerList() {
        return activityPassengerList;
    }

    public void setActivityPassengerList(List<ActivityPassenger> activityPassengerList) {
        this.activityPassengerList = activityPassengerList;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerCategory() {
        return passengerCategory;
    }

    public float getBalance() {
        return balance;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassengerCategory(String passengerCategory) {
        this.passengerCategory = passengerCategory;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
