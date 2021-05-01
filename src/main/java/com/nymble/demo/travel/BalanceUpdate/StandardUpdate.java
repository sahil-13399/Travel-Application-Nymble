package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class StandardUpdate implements BalanceUpdate{

    @Override
    public float updateBalance(Passenger passenger, Activity activity) {
        float cost = activity.getActivityCost();
        float balance = passenger.getBalance();
        if(cost > balance) {
            return -1;
        }
        balance -= cost;
        passenger.setBalance(balance);
        return cost;
    }
}
