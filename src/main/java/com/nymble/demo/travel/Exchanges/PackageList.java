package com.nymble.demo.travel.Exchanges;

import lombok.Data;

import java.util.List;

@Data
public class PackageList {
    private String packageName;
    private List<DestinationList> destinationList;
}
