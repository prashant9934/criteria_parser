package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Variable {

    @SerializedName("$1")
    @Expose
    public DollarOne $1;
    @SerializedName("$2")
    @Expose
    public DollarTwo $2;
    @SerializedName("$3")
    @Expose
    public DollarThree $3;
    @SerializedName("$4")
    @Expose
    public DollarFour $4;
}
