package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Destination;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class PackageList {
    @NonNull
    private String packageName;
    @NonNull
    private List<Destination> destinationList;
}
