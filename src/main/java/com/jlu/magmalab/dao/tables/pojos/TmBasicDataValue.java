/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmBasicDataValue implements Serializable {

    private static final long serialVersionUID = -1931015644;

    private String  dataId;
    private Integer eleIndex;
    private Double  dataValue;

    public TmBasicDataValue() {}

    public TmBasicDataValue(TmBasicDataValue value) {
        this.dataId = value.dataId;
        this.eleIndex = value.eleIndex;
        this.dataValue = value.dataValue;
    }

    public TmBasicDataValue(
        String  dataId,
        Integer eleIndex,
        Double  dataValue
    ) {
        this.dataId = dataId;
        this.eleIndex = eleIndex;
        this.dataValue = dataValue;
    }

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getEleIndex() {
        return this.eleIndex;
    }

    public void setEleIndex(Integer eleIndex) {
        this.eleIndex = eleIndex;
    }

    public Double getDataValue() {
        return this.dataValue;
    }

    public void setDataValue(Double dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TmBasicDataValue (");

        sb.append(dataId);
        sb.append(", ").append(eleIndex);
        sb.append(", ").append(dataValue);

        sb.append(")");
        return sb.toString();
    }
}