/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.records;


import com.jlu.magmalab.dao.tables.TmRole;

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
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmRoleRecord extends UpdatableRecordImpl<TmRoleRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1162359184;

    /**
     * Setter for <code>magmLab.TM_ROLE.ROLE_ID</code>.
     */
    public void setRoleId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>magmLab.TM_ROLE.ROLE_ID</code>.
     */
    public String getRoleId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>magmLab.TM_ROLE.ROLE_NAME</code>.
     */
    public void setRoleName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magmLab.TM_ROLE.ROLE_NAME</code>.
     */
    public String getRoleName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magmLab.TM_ROLE.MEMO</code>.
     */
    public void setMemo(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>magmLab.TM_ROLE.MEMO</code>.
     */
    public String getMemo() {
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
        return TmRole.TM_ROLE.ROLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TmRole.TM_ROLE.ROLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TmRole.TM_ROLE.MEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getRoleName();
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
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getRoleName();
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
    public TmRoleRecord value1(String value) {
        setRoleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmRoleRecord value2(String value) {
        setRoleName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmRoleRecord value3(String value) {
        setMemo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmRoleRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TmRoleRecord
     */
    public TmRoleRecord() {
        super(TmRole.TM_ROLE);
    }

    /**
     * Create a detached, initialised TmRoleRecord
     */
    public TmRoleRecord(String roleId, String roleName, String memo) {
        super(TmRole.TM_ROLE);

        set(0, roleId);
        set(1, roleName);
        set(2, memo);
    }
}
