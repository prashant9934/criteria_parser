package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class DollarOne {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("values")
    @Expose
    public List<Integer> values = null;
    @SerializedName("study_type")
    @Expose
    public String studyType;
    @SerializedName("parameter_name")
    @Expose
    public String parameterName;
    @SerializedName("min_value")
    @Expose
    public Integer minValue;
    @SerializedName("max_value")
    @Expose
    public Integer maxValue;
    @SerializedName("default_value")
    @Expose
    public Integer defaultValue;
}
