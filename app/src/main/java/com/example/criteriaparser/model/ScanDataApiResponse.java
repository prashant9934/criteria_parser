package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class ScanDataApiResponse {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("criteria")
    @Expose
    public List<Criterium> criteria = null;
}
