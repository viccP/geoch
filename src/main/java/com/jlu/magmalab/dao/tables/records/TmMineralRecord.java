/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmMineral;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


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
public class TmMineralRecord extends TableRecordImpl<TmMineralRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 305257903;

    /**
     * Setter for <code>magmLab.TM_MINERAL.MINERAL_ID</code>.
     */
    public void setMineralId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_MINERAL.MINERAL_ID</code>.
     */
    public String getMineralId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_MINERAL.MINERAL_NAME</code>.
     */
    public void setMineralName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_MINERAL.MINERAL_NAME</code>.
     */
    public String getMineralName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magmLab.TM_MINERAL.MEMO</code>.
     */
    public void setMemo(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>magmLab.TM_MINERAL.MEMO</code>.
     */
    public String getMemo() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TmMineral.TM_MINERAL.MINERAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TmMineral.TM_MINERAL.MINERAL_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TmMineral.TM_MINERAL.MEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getMineralId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMineralName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getMineralId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMineralName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMineralRecord value1(String value) {
        setMineralId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMineralRecord value2(String value) {
        setMineralName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMineralRecord value3(String value) {
        setMemo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmMineralRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmMineralRecord
     */
    public TmMineralRecord() {
        super(TmMineral.TM_MINERAL);
    }

    /**
     * Create a detached, initialised TmMineralRecord
     */
    public TmMineralRecord(String mineralId, String mineralName, String memo) {
        super(TmMineral.TM_MINERAL);

        set(0, mineralId);
        set(1, mineralName);
        set(2, memo);
    }
}