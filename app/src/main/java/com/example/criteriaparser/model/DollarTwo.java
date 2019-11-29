package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class DollarTwo {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("values")
    @Expose
    public List<String> values = null;
}
