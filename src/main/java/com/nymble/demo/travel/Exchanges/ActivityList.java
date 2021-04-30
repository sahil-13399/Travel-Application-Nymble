package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Activity;
import lombok.Data;
import lombok.NonNull;

@Data
public class ActivityList {
    @NonNull
    private Activity activity;
    @NonNull
    private int vacantSpaces;

    public void reduceVacantSeats() {
        if(vacantSpaces != 0) {
            vacantSpaces -= 1;
        }
    }
}
