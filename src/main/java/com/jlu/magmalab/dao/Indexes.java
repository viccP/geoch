/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao;


import com.jlu.magmalab.dao.tables.TmDistributeValue;
import com.jlu.magmalab.dao.tables.TmElement;
import com.jlu.magmalab.dao.tables.TmExpr;
import com.jlu.magmalab.dao.tables.TmInitialType;
import com.jlu.magmalab.dao.tables.TmInitialValue;
import com.jlu.magmalab.dao.tables.TmMeltType;
import com.jlu.magmalab.dao.tables.TmMineral;
import com.jlu.magmalab.dao.tables.TmMixType;
import com.jlu.magmalab.dao.tables.TmMixValue;
import com.jlu.magmalab.dao.tables.TmRole;
import com.jlu.magmalab.dao.tables.TmStdType;
import com.jlu.magmalab.dao.tables.TmStdValue;
import com.jlu.magmalab.dao.tables.TmUser;
import com.jlu.magmalab.dao.tables.TmUserRole;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>magmLab</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index TM_DISTRIBUTE_VALUE_PRIMARY = Indexes0.TM_DISTRIBUTE_VALUE_PRIMARY;
    public static final Index TM_ELEMENT_PRIMARY = Indexes0.TM_ELEMENT_PRIMARY;
    public static final Index TM_EXPR_PRIMARY = Indexes0.TM_EXPR_PRIMARY;
    public static final Index TM_INITIAL_TYPE_PRIMARY = Indexes0.TM_INITIAL_TYPE_PRIMARY;
    public static final Index TM_INITIAL_VALUE_PRIMARY = Indexes0.TM_INITIAL_VALUE_PRIMARY;
    public static final Index TM_MELT_TYPE_PRIMARY = Indexes0.TM_MELT_TYPE_PRIMARY;
    public static final Index TM_MINERAL_PRIMARY = Indexes0.TM_MINERAL_PRIMARY;
    public static final Index TM_MIX_TYPE_PRIMARY = Indexes0.TM_MIX_TYPE_PRIMARY;
    public static final Index TM_MIX_VALUE_FK_RELATIONSHIP_1 = Indexes0.TM_MIX_VALUE_FK_RELATIONSHIP_1;
    public static final Index TM_MIX_VALUE_PRIMARY = Indexes0.TM_MIX_VALUE_PRIMARY;
    public static final Index TM_ROLE_PRIMARY = Indexes0.TM_ROLE_PRIMARY;
    public static final Index TM_STD_TYPE_PRIMARY = Indexes0.TM_STD_TYPE_PRIMARY;
    public static final Index TM_STD_VALUE_FK_RELATIONSHIP_2 = Indexes0.TM_STD_VALUE_FK_RELATIONSHIP_2;
    public static final Index TM_STD_VALUE_PRIMARY = Indexes0.TM_STD_VALUE_PRIMARY;
    public static final Index TM_USER_PRIMARY = Indexes0.TM_USER_PRIMARY;
    public static final Index TM_USER_ROLE_PRIMARY = Indexes0.TM_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index TM_DISTRIBUTE_VALUE_PRIMARY = Internal.createIndex("PRIMARY", TmDistributeValue.TM_DISTRIBUTE_VALUE, new OrderField[] { TmDistributeValue.TM_DISTRIBUTE_VALUE.ELE_INDEX, TmDistributeValue.TM_DISTRIBUTE_VALUE.MINERAL_INDEX, TmDistributeValue.TM_DISTRIBUTE_VALUE.MELT_INDEX }, true);
        public static Index TM_ELEMENT_PRIMARY = Internal.createIndex("PRIMARY", TmElement.TM_ELEMENT, new OrderField[] { TmElement.TM_ELEMENT.INDEX }, true);
        public static Index TM_EXPR_PRIMARY = Internal.createIndex("PRIMARY", TmExpr.TM_EXPR, new OrderField[] { TmExpr.TM_EXPR.EXPR_ID }, true);
        public static Index TM_INITIAL_TYPE_PRIMARY = Internal.createIndex("PRIMARY", TmInitialType.TM_INITIAL_TYPE, new OrderField[] { TmInitialType.TM_INITIAL_TYPE.INITIAL_ID }, true);
        public static Index TM_INITIAL_VALUE_PRIMARY = Internal.createIndex("PRIMARY", TmInitialValue.TM_INITIAL_VALUE, new OrderField[] { TmInitialValue.TM_INITIAL_VALUE.INITIAL_ID, TmInitialValue.TM_INITIAL_VALUE.ELE_INDEX }, true);
        public static Index TM_MELT_TYPE_PRIMARY = Internal.createIndex("PRIMARY", TmMeltType.TM_MELT_TYPE, new OrderField[] { TmMeltType.TM_MELT_TYPE.INDEX }, true);
        public static Index TM_MINERAL_PRIMARY = Internal.createIndex("PRIMARY", TmMineral.TM_MINERAL, new OrderField[] { TmMineral.TM_MINERAL.INDEX }, true);
        public static Index TM_MIX_TYPE_PRIMARY = Internal.createIndex("PRIMARY", TmMixType.TM_MIX_TYPE, new OrderField[] { TmMixType.TM_MIX_TYPE.MIX_ID, TmMixType.TM_MIX_TYPE.MIX_NAME }, true);
        public static Index TM_MIX_VALUE_FK_RELATIONSHIP_1 = Internal.createIndex("FK_Relationship_1", TmMixValue.TM_MIX_VALUE, new OrderField[] { TmMixValue.TM_MIX_VALUE.MIX_ID }, false);
        public static Index TM_MIX_VALUE_PRIMARY = Internal.createIndex("PRIMARY", TmMixValue.TM_MIX_VALUE, new OrderField[] { TmMixValue.TM_MIX_VALUE.ELE_INDEX, TmMixValue.TM_MIX_VALUE.MIX_ID }, true);
        public static Index TM_ROLE_PRIMARY = Internal.createIndex("PRIMARY", TmRole.TM_ROLE, new OrderField[] { TmRole.TM_ROLE.ROLE_ID }, true);
        public static Index TM_STD_TYPE_PRIMARY = Internal.createIndex("PRIMARY", TmStdType.TM_STD_TYPE, new OrderField[] { TmStdType.TM_STD_TYPE.STD_ID }, true);
        public static Index TM_STD_VALUE_FK_RELATIONSHIP_2 = Internal.createIndex("FK_Relationship_2", TmStdValue.TM_STD_VALUE, new OrderField[] { TmStdValue.TM_STD_VALUE.STD_ID }, false);
        public static Index TM_STD_VALUE_PRIMARY = Internal.createIndex("PRIMARY", TmStdValue.TM_STD_VALUE, new OrderField[] { TmStdValue.TM_STD_VALUE.ELE_INDEX, TmStdValue.TM_STD_VALUE.STD_ID }, true);
        public static Index TM_USER_PRIMARY = Internal.createIndex("PRIMARY", TmUser.TM_USER, new OrderField[] { TmUser.TM_USER.USER_ID }, true);
        public static Index TM_USER_ROLE_PRIMARY = Internal.createIndex("PRIMARY", TmUserRole.TM_USER_ROLE, new OrderField[] { TmUserRole.TM_USER_ROLE.USER_ID, TmUserRole.TM_USER_ROLE.ROLE_ID }, true);
    }
}
