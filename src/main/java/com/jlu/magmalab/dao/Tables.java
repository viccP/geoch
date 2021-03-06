/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao;


import com.jlu.magmalab.dao.tables.TmBasicDataType;
import com.jlu.magmalab.dao.tables.TmBasicDataValue;
import com.jlu.magmalab.dao.tables.TmDistributeValue;
import com.jlu.magmalab.dao.tables.TmElement;
import com.jlu.magmalab.dao.tables.TmExpr;
import com.jlu.magmalab.dao.tables.TmLabReport;
import com.jlu.magmalab.dao.tables.TmMeltType;
import com.jlu.magmalab.dao.tables.TmMineral;
import com.jlu.magmalab.dao.tables.TmRole;
import com.jlu.magmalab.dao.tables.TmUser;
import com.jlu.magmalab.dao.tables.TmUserRole;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in magmLab
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>magmLab.TM_BASIC_DATA_TYPE</code>.
     */
    public static final TmBasicDataType TM_BASIC_DATA_TYPE = com.jlu.magmalab.dao.tables.TmBasicDataType.TM_BASIC_DATA_TYPE;

    /**
     * The table <code>magmLab.TM_BASIC_DATA_VALUE</code>.
     */
    public static final TmBasicDataValue TM_BASIC_DATA_VALUE = com.jlu.magmalab.dao.tables.TmBasicDataValue.TM_BASIC_DATA_VALUE;

    /**
     * The table <code>magmLab.TM_DISTRIBUTE_VALUE</code>.
     */
    public static final TmDistributeValue TM_DISTRIBUTE_VALUE = com.jlu.magmalab.dao.tables.TmDistributeValue.TM_DISTRIBUTE_VALUE;

    /**
     * The table <code>magmLab.TM_ELEMENT</code>.
     */
    public static final TmElement TM_ELEMENT = com.jlu.magmalab.dao.tables.TmElement.TM_ELEMENT;

    /**
     * The table <code>magmLab.TM_EXPR</code>.
     */
    public static final TmExpr TM_EXPR = com.jlu.magmalab.dao.tables.TmExpr.TM_EXPR;

    /**
     * The table <code>magmLab.TM_LAB_REPORT</code>.
     */
    public static final TmLabReport TM_LAB_REPORT = com.jlu.magmalab.dao.tables.TmLabReport.TM_LAB_REPORT;

    /**
     * The table <code>magmLab.TM_MELT_TYPE</code>.
     */
    public static final TmMeltType TM_MELT_TYPE = com.jlu.magmalab.dao.tables.TmMeltType.TM_MELT_TYPE;

    /**
     * The table <code>magmLab.TM_MINERAL</code>.
     */
    public static final TmMineral TM_MINERAL = com.jlu.magmalab.dao.tables.TmMineral.TM_MINERAL;

    /**
     * The table <code>magmLab.TM_ROLE</code>.
     */
    public static final TmRole TM_ROLE = com.jlu.magmalab.dao.tables.TmRole.TM_ROLE;

    /**
     * 用户表
     */
    public static final TmUser TM_USER = com.jlu.magmalab.dao.tables.TmUser.TM_USER;

    /**
     * The table <code>magmLab.TM_USER_ROLE</code>.
     */
    public static final TmUserRole TM_USER_ROLE = com.jlu.magmalab.dao.tables.TmUserRole.TM_USER_ROLE;
}
