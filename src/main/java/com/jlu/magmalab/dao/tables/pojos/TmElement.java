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
public class TmElement implements Serializable {

    private static final long serialVersionUID = -687154767;

    private Integer index;
    private String  elementCode;
    private String  elementName;
    private String  elementPronounce;

    public TmElement() {}

    public TmElement(TmElement value) {
        this.index = value.index;
        this.elementCode = value.elementCode;
        this.elementName = value.elementName;
        this.elementPronounce = value.elementPronounce;
    }

    public TmElement(
        Integer index,
        String  elementCode,
        String  elementName,
        String  elementPronounce
    ) {
        this.index = index;
        this.elementCode = elementCode;
        this.elementName = elementName;
        this.elementPronounce = elementPronounce;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getElementCode() {
        return this.elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementPronounce() {
        return this.elementPronounce;
    }

    public void setElementPronounce(String elementPronounce) {
        this.elementPronounce = elementPronounce;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TmElement (");

        sb.append(index);
        sb.append(", ").append(elementCode);
        sb.append(", ").append(elementName);
        sb.append(", ").append(elementPronounce);

        sb.append(")");
        return sb.toString();
    }
}
