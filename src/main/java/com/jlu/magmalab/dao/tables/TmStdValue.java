/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables;


import com.jlu.magmalab.dao.Indexes;
import com.jlu.magmalab.dao.Keys;
import com.jlu.magmalab.dao.Magmlab;
import com.jlu.magmalab.dao.tables.records.TmStdValueRecord;

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
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmStdValue extends TableImpl<TmStdValueRecord> {

    private static final long serialVersionUID = 297787590;

    /**
     * The reference instance of <code>magmLab.TM_STD_VALUE</code>
     */
    public static final TmStdValue TM_STD_VALUE = new TmStdValue();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TmStdValueRecord> getRecordType() {
        return TmStdValueRecord.class;
    }

    /**
     * The column <code>magmLab.TM_STD_VALUE.ELE_NAME</code>.
     */
    public final TableField<TmStdValueRecord, String> ELE_NAME = createField("ELE_NAME", org.jooq.impl.SQLDataType.CHAR(30).nullable(false), this, "");

    /**
     * The column <code>magmLab.TM_STD_VALUE.STD_ID</code>.
     */
    public final TableField<TmStdValueRecord, String> STD_ID = createField("STD_ID", org.jooq.impl.SQLDataType.CHAR(48), this, "");

    /**
     * The column <code>magmLab.TM_STD_VALUE.STD_VALUE</code>.
     */
    public final TableField<TmStdValueRecord, Double> STD_VALUE = createField("STD_VALUE", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>magmLab.TM_STD_VALUE</code> table reference
     */
    public TmStdValue() {
        this(DSL.name("TM_STD_VALUE"), null);
    }

    /**
     * Create an aliased <code>magmLab.TM_STD_VALUE</code> table reference
     */
    public TmStdValue(String alias) {
        this(DSL.name(alias), TM_STD_VALUE);
    }

    /**
     * Create an aliased <code>magmLab.TM_STD_VALUE</code> table reference
     */
    public TmStdValue(Name alias) {
        this(alias, TM_STD_VALUE);
    }

    private TmStdValue(Name alias, Table<TmStdValueRecord> aliased) {
        this(alias, aliased, null);
    }

    private TmStdValue(Name alias, Table<TmStdValueRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.TM_STD_VALUE_FK_RELATIONSHIP_2, Indexes.TM_STD_VALUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TmStdValueRecord> getPrimaryKey() {
        return Keys.KEY_TM_STD_VALUE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TmStdValueRecord>> getKeys() {
        return Arrays.<UniqueKey<TmStdValueRecord>>asList(Keys.KEY_TM_STD_VALUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdValue as(String alias) {
        return new TmStdValue(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmStdValue as(Name alias) {
        return new TmStdValue(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TmStdValue rename(String name) {
        return new TmStdValue(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TmStdValue rename(Name name) {
        return new TmStdValue(name, null);
    }
}
