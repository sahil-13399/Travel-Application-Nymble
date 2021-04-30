package com.nymble.demo.travel.dto;

import com.nymble.demo.travel.Exchanges.ActivityPassenger;

import java.util.List;


public class Passenger {
    private int passengerId;
    private String passengerName;
    private String passengerCategory;
    private int balance;
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

    public int getBalance() {
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

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
