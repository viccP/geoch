/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables;


import com.jlu.magmalab.dao.Indexes;
import com.jlu.magmalab.dao.Keys;
import com.jlu.magmalab.dao.Magmlab;
import com.jlu.magmalab.dao.tables.records.TmDistributeValueRecord;

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
public class TmDistributeValue extends TableImpl<TmDistributeValueRecord> {

    private static final long serialVersionUID = -1009580108;

    /**
     * The reference instance of <code>magmLab.TM_DISTRIBUTE_VALUE</code>
     */
    public static final TmDistributeValue TM_DISTRIBUTE_VALUE = new TmDistributeValue();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TmDistributeValueRecord> getRecordType() {
        return TmDistributeValueRecord.class;
    }

    /**
     * The column <code>magmLab.TM_DISTRIBUTE_VALUE.ELE_INDEX</code>.
     */
    public final TableField<TmDistributeValueRecord, Integer> ELE_INDEX = createField("ELE_INDEX", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>magmLab.TM_DISTRIBUTE_VALUE.MINERAL_INDEX</code>.
     */
    public final TableField<TmDistributeValueRecord, Integer> MINERAL_INDEX = createField("MINERAL_INDEX", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>magmLab.TM_DISTRIBUTE_VALUE.MELT_INDEX</code>.
     */
    public final TableField<TmDistributeValueRecord, Integer> MELT_INDEX = createField("MELT_INDEX", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>magmLab.TM_DISTRIBUTE_VALUE.DISTRIBUTE_VALUE</code>.
     */
    public final TableField<TmDistributeValueRecord, Double> DISTRIBUTE_VALUE = createField("DISTRIBUTE_VALUE", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>magmLab.TM_DISTRIBUTE_VALUE</code> table reference
     */
    public TmDistributeValue() {
        this(DSL.name("TM_DISTRIBUTE_VALUE"), null);
    }

    /**
     * Create an aliased <code>magmLab.TM_DISTRIBUTE_VALUE</code> table reference
     */
    public TmDistributeValue(String alias) {
        this(DSL.name(alias), TM_DISTRIBUTE_VALUE);
    }

    /**
     * Create an aliased <code>magmLab.TM_DISTRIBUTE_VALUE</code> table reference
     */
    public TmDistributeValue(Name alias) {
        this(alias, TM_DISTRIBUTE_VALUE);
    }

    private TmDistributeValue(Name alias, Table<TmDistributeValueRecord> aliased) {
        this(alias, aliased, null);
    }

    private TmDistributeValue(Name alias, Table<TmDistributeValueRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.TM_DISTRIBUTE_VALUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TmDistributeValueRecord> getPrimaryKey() {
        return Keys.KEY_TM_DISTRIBUTE_VALUE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TmDistributeValueRecord>> getKeys() {
        return Arrays.<UniqueKey<TmDistributeValueRecord>>asList(Keys.KEY_TM_DISTRIBUTE_VALUE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmDistributeValue as(String alias) {
        return new TmDistributeValue(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmDistributeValue as(Name alias) {
        return new TmDistributeValue(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TmDistributeValue rename(String name) {
        return new TmDistributeValue(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TmDistributeValue rename(Name name) {
        return new TmDistributeValue(name, null);
    }
}
