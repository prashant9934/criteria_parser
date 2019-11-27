package com.example.criteriaparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variable {

    @SerializedName("$1")
    @Expose
    private DollarOne $1;
    @SerializedName("$2")
    @Expose
    private DollarTwo $2;
    @SerializedName("$3")
    @Expose
    private DollarThree $3;
    @SerializedName("$4")
    @Expose
    private DollarFour $4;

    public DollarOne get$1() {
        return $1;
    }

    public void set$1(DollarOne $1) {
        this.$1 = $1;
    }

    public DollarTwo get$2() {
        return $2;
    }

    public void set$2(DollarTwo $2) {
        this.$2 = $2;
    }

    public DollarThree get$3() {
        return $3;
    }

    public void set$3(DollarThree $3) {
        this.$3 = $3;
    }

    public DollarFour get$4() {
        return $4;
    }

    public void set$4(DollarFour $4) {
        this.$4 = $4;
    }
}
