package com.nymble.demo.travel.Exchanges;

import lombok.Data;

import java.util.List;

@Data
public class ActivityList {
    private String packageName;
    private List<DestinationList> destinationList;
}
