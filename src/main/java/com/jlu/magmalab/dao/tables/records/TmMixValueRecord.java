/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmMixValue;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmMixValueRecord extends UpdatableRecordImpl<TmMixValueRecord> implements Record3<String, String, Double> {

    private static final long serialVersionUID = 730455516;

    /**
     * Setter for <code>magmLab.TM_MIX_VALUE.ELE_NAME</code>.
     */
    public void setEleName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_MIX_VALUE.ELE_NAME</code>.
     */
    public String getEleName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_MIX_VALUE.MIX_ID</code>.
     */
    public void setMixId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_MIX_VALUE.MIX_ID</code>.
     */
    public String getMixId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magmLab.TM_MIX_VALUE.MIX_VALUE</code>.
     */
    public void setMixValue(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>magmLab.TM_MIX_VALUE.MIX_VALUE</code>.
     */
    public Double getMixValue() {
        return (Double) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Double> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Double> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TmMixValue.TM_MIX_VALUE.ELE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TmMixValue.TM_MIX_VALUE.MIX_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field3() {
        return TmMixValue.TM_MIX_VALUE.MIX_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getEleName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMixId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component3() {
        return getMixValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEleName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMixId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value3() {
        return getMixValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMixValueRecord value1(String value) {
        setEleName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMixValueRecord value2(String value) {
        setMixId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMixValueRecord value3(Double value) {
        setMixValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMixValueRecord values(String value1, String value2, Double value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmMixValueRecord
     */
    public TmMixValueRecord() {
        super(TmMixValue.TM_MIX_VALUE);
    }

    /**
     * Create a detached, initialised TmMixValueRecord
     */
    public TmMixValueRecord(String eleName, String mixId, Double mixValue) {
        super(TmMixValue.TM_MIX_VALUE);

        set(0, eleName);
        set(1, mixId);
        set(2, mixValue);
    }
}