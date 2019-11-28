package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Criterium extends BaseCriterium{

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("variable")
    @Expose
    public Variable variable;
}
