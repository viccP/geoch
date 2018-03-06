/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmMeltType;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class TmMeltTypeRecord extends UpdatableRecordImpl<TmMeltTypeRecord> implements Record2<String, Integer> {

    private static final long serialVersionUID = -1823224095;

    /**
     * Setter for <code>magmLab.TM_MELT_TYPE.MELT_NAME</code>.
     */
    public void setMeltName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_MELT_TYPE.MELT_NAME</code>.
     */
    public String getMeltName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_MELT_TYPE.MELT_TYPE</code>.
     */
    public void setMeltType(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_MELT_TYPE.MELT_TYPE</code>.
     */
    public Integer getMeltType() {
        return (Integer) get(1);
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
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TmMeltType.TM_MELT_TYPE.MELT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TmMeltType.TM_MELT_TYPE.MELT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getMeltName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getMeltType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getMeltName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getMeltType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMeltTypeRecord value1(String value) {
        setMeltName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMeltTypeRecord value2(Integer value) {
        setMeltType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMeltTypeRecord values(String value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmMeltTypeRecord
     */
    public TmMeltTypeRecord() {
        super(TmMeltType.TM_MELT_TYPE);
    }

    /**
     * Create a detached, initialised TmMeltTypeRecord
     */
    public TmMeltTypeRecord(String meltName, Integer meltType) {
        super(TmMeltType.TM_MELT_TYPE);

        set(0, meltName);
        set(1, meltType);
    }
}
