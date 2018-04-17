package com.jjpods.codechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListItem  {

    String name,city,state,endDate;

    public ListItem(String name ,String city, String state, String endDate){
        this.name = name;
        this.city = city;
        this.state = state;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getEndDate() {
        return endDate;
    }
}
