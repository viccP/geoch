/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmElement;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TmElementRecord extends UpdatableRecordImpl<TmElementRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 1215555505;

    /**
     * Setter for <code>magmLab.TM_ELEMENT.INDEX</code>. 序号
     */
    public void setIndex(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_ELEMENT.INDEX</code>. 序号
     */
    public Integer getIndex() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_ELEMENT.ELEMENT_CODE</code>. 元素编码
     */
    public void setElementCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_ELEMENT.ELEMENT_CODE</code>. 元素编码
     */
    public String getElementCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magmLab.TM_ELEMENT.ELEMENT_NAME</code>. 元素名称
     */
    public void setElementName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>magmLab.TM_ELEMENT.ELEMENT_NAME</code>. 元素名称
     */
    public String getElementName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>magmLab.TM_ELEMENT.ELEMENT_PRONOUNCE</code>. 元素发音
     */
    public void setElementPronounce(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>magmLab.TM_ELEMENT.ELEMENT_PRONOUNCE</code>. 元素发音
     */
    public String getElementPronounce() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TmElement.TM_ELEMENT.INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TmElement.TM_ELEMENT.ELEMENT_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TmElement.TM_ELEMENT.ELEMENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TmElement.TM_ELEMENT.ELEMENT_PRONOUNCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getElementCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getElementName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getElementPronounce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getElementCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getElementName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getElementPronounce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmElementRecord value1(Integer value) {
        setIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmElementRecord value2(String value) {
        setElementCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmElementRecord value3(String value) {
        setElementName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmElementRecord value4(String value) {
        setElementPronounce(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmElementRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmElementRecord
     */
    public TmElementRecord() {
        super(TmElement.TM_ELEMENT);
    }

    /**
     * Create a detached, initialised TmElementRecord
     */
    public TmElementRecord(Integer index, String elementCode, String elementName, String elementPronounce) {
        super(TmElement.TM_ELEMENT);

        set(0, index);
        set(1, elementCode);
        set(2, elementName);
        set(3, elementPronounce);
    }
}
