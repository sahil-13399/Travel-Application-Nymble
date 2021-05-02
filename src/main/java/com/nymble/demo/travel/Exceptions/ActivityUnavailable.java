/**
 <h1>Activity Unavailable exception</h1>
 When the activity name is not found
 while searching then we throw this
 exception.
 @exception ActivityUnavailable exception when activity is not found

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */
package com.nymble.demo.travel.Exceptions;

public class ActivityUnavailable extends Exception{
    public ActivityUnavailable(String message) {
        super(message);
    }
}
