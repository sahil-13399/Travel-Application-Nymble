/**
 <h1>PackageList Class</h1>
 Contains the variables and
 methods of PackageList class

 @param packageName : type String
 @param destinationList : type List<Destination>

  * @author  Sahil Samantaray
  * @version 1.0
  * @since   2021-05-01
 */

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
