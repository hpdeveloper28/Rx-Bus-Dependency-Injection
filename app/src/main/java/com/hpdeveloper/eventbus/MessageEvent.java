package com.hpdeveloper.eventbus;

/**
 * Created by hirenpatel on 11/10/17.
 */

public class MessageEvent {

    public MessageEvent(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String name;
    public String address;
}
