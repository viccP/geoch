/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables;


import com.jlu.magmalab.dao.Indexes;
import com.jlu.magmalab.dao.Keys;
import com.jlu.magmalab.dao.Magmlab;
import com.jlu.magmalab.dao.tables.records.TmExprRecord;

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
public class TmExpr extends TableImpl<TmExprRecord> {

    private static final long serialVersionUID = 557076364;

    /**
     * The reference instance of <code>magmLab.TM_EXPR</code>
     */
    public static final TmExpr TM_EXPR = new TmExpr();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TmExprRecord> getRecordType() {
        return TmExprRecord.class;
    }

    /**
     * The column <code>magmLab.TM_EXPR.EXPR_ID</code>. UUID
     */
    public final TableField<TmExprRecord, String> EXPR_ID = createField("EXPR_ID", org.jooq.impl.SQLDataType.CHAR(48).nullable(false), this, "UUID");

    /**
     * The column <code>magmLab.TM_EXPR.EXPR_NAME</code>. 公式名称
     */
    public final TableField<TmExprRecord, String> EXPR_NAME = createField("EXPR_NAME", org.jooq.impl.SQLDataType.CHAR(20), this, "公式名称");

    /**
     * The column <code>magmLab.TM_EXPR.EXPR_CLASS_PATH</code>. 类路径
     */
    public final TableField<TmExprRecord, String> EXPR_CLASS_PATH = createField("EXPR_CLASS_PATH", org.jooq.impl.SQLDataType.CHAR(100), this, "类路径");

    /**
     * The column <code>magmLab.TM_EXPR.EXPR_TYPE</code>. 0:结晶 1：混染
     */
    public final TableField<TmExprRecord, Integer> EXPR_TYPE = createField("EXPR_TYPE", org.jooq.impl.SQLDataType.INTEGER, this, "0:结晶 1：混染");

    /**
     * The column <code>magmLab.TM_EXPR.MEMO</code>. 备注
     */
    public final TableField<TmExprRecord, String> MEMO = createField("MEMO", org.jooq.impl.SQLDataType.CHAR(255), this, "备注");

    /**
     * Create a <code>magmLab.TM_EXPR</code> table reference
     */
    public TmExpr() {
        this(DSL.name("TM_EXPR"), null);
    }

    /**
     * Create an aliased <code>magmLab.TM_EXPR</code> table reference
     */
    public TmExpr(String alias) {
        this(DSL.name(alias), TM_EXPR);
    }

    /**
     * Create an aliased <code>magmLab.TM_EXPR</code> table reference
     */
    public TmExpr(Name alias) {
        this(alias, TM_EXPR);
    }

    private TmExpr(Name alias, Table<TmExprRecord> aliased) {
        this(alias, aliased, null);
    }

    private TmExpr(Name alias, Table<TmExprRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.TM_EXPR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TmExprRecord> getPrimaryKey() {
        return Keys.KEY_TM_EXPR_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TmExprRecord>> getKeys() {
        return Arrays.<UniqueKey<TmExprRecord>>asList(Keys.KEY_TM_EXPR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmExpr as(String alias) {
        return new TmExpr(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TmExpr as(Name alias) {
        return new TmExpr(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TmExpr rename(String name) {
        return new TmExpr(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TmExpr rename(Name name) {
        return new TmExpr(name, null);
    }
}