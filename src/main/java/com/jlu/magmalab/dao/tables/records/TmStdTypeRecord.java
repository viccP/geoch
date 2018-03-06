/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmStdType;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
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
public class TmStdTypeRecord extends UpdatableRecordImpl<TmStdTypeRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 732431200;

    /**
     * Setter for <code>magmLab.TM_STD_TYPE.STD_ID</code>.
     */
    public void setStdId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_STD_TYPE.STD_ID</code>.
     */
    public String getStdId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_STD_TYPE.STD_NAME</code>.
     */
    public void setStdName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_STD_TYPE.STD_NAME</code>.
     */
    public String getStdName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magmLab.TM_STD_TYPE.STD_MEMO</code>.
     */
    public void setStdMemo(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>magmLab.TM_STD_TYPE.STD_MEMO</code>.
     */
    public String getStdMemo() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
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
        return TmStdType.TM_STD_TYPE.STD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TmStdType.TM_STD_TYPE.STD_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TmStdType.TM_STD_TYPE.STD_MEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getStdId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getStdName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getStdMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getStdId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getStdName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getStdMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdTypeRecord value1(String value) {
        setStdId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdTypeRecord value2(String value) {
        setStdName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdTypeRecord value3(String value) {
        setStdMemo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdTypeRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmStdTypeRecord
     */
    public TmStdTypeRecord() {
        super(TmStdType.TM_STD_TYPE);
    }

    /**
     * Create a detached, initialised TmStdTypeRecord
     */
    public TmStdTypeRecord(String stdId, String stdName, String stdMemo) {
        super(TmStdType.TM_STD_TYPE);

        set(0, stdId);
        set(1, stdName);
        set(2, stdMemo);
    }
}
