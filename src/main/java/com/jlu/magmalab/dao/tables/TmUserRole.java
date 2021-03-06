/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables;


import com.jlu.magmalab.dao.Indexes;
import com.jlu.magmalab.dao.Keys;
import com.jlu.magmalab.dao.Magmlab;
import com.jlu.magmalab.dao.tables.records.TmUserRoleRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TmUserRole extends TableImpl<TmUserRoleRecord> {

    private static final long serialVersionUID = 1211464966;

    /**
     * The reference instance of <code>magmLab.TM_USER_ROLE</code>
     */
    public static final TmUserRole TM_USER_ROLE = new TmUserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TmUserRoleRecord> getRecordType() {
        return TmUserRoleRecord.class;
    }

    /**
     * The column <code>magmLab.TM_USER_ROLE.USER_ID</code>.
     */
    public final TableField<TmUserRoleRecord, String> USER_ID = createField("USER_ID", org.jooq.impl.SQLDataType.CHAR(48).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>magmLab.TM_USER_ROLE.ROLE_ID</code>.
     */
    public final TableField<TmUserRoleRecord, String> ROLE_ID = createField("ROLE_ID", org.jooq.impl.SQLDataType.CHAR(48).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * Create a <code>magmLab.TM_USER_ROLE</code> table reference
     */
    public TmUserRole() {
        this(DSL.name("TM_USER_ROLE"), null);
    }

    /**
     * Create an aliased <code>magmLab.TM_USER_ROLE</code> table reference
     */
    public TmUserRole(String alias) {
        this(DSL.name(alias), TM_USER_ROLE);
    }

    /**
     * Create an aliased <code>magmLab.TM_USER_ROLE</code> table reference
     */
    public TmUserRole(Name alias) {
        this(alias, TM_USER_ROLE);
    }

    private TmUserRole(Name alias, Table<TmUserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private TmUserRole(Name alias, Table<TmUserRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Magmlab.MAGMLAB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TM_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TmUserRoleRecord> getPrimaryKey() {
        return Keys.KEY_TM_USER_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TmUserRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<TmUserRoleRecord>>asList(Keys.KEY_TM_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmUserRole as(String alias) {
        return new TmUserRole(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmUserRole as(Name alias) {
        return new TmUserRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TmUserRole rename(String name) {
        return new TmUserRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TmUserRole rename(Name name) {
        return new TmUserRole(name, null);
    }
}
