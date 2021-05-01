package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.Exceptions.BalanceInsufficient;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public interface BalanceUpdate {
    float updateBalance(Passenger passenger, Activity activity) throws BalanceInsufficient;
}
