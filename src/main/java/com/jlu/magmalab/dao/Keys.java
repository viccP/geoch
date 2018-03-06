/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao;


import com.jlu.magmalab.dao.tables.TmDistributeValue;
import com.jlu.magmalab.dao.tables.TmMeltType;
import com.jlu.magmalab.dao.tables.TmMixType;
import com.jlu.magmalab.dao.tables.TmMixValue;
import com.jlu.magmalab.dao.tables.TmRole;
import com.jlu.magmalab.dao.tables.TmStdType;
import com.jlu.magmalab.dao.tables.TmStdValue;
import com.jlu.magmalab.dao.tables.TmUser;
import com.jlu.magmalab.dao.tables.TmUserRole;
import com.jlu.magmalab.dao.tables.records.TmDistributeValueRecord;
import com.jlu.magmalab.dao.tables.records.TmMeltTypeRecord;
import com.jlu.magmalab.dao.tables.records.TmMixTypeRecord;
import com.jlu.magmalab.dao.tables.records.TmMixValueRecord;
import com.jlu.magmalab.dao.tables.records.TmRoleRecord;
import com.jlu.magmalab.dao.tables.records.TmStdTypeRecord;
import com.jlu.magmalab.dao.tables.records.TmStdValueRecord;
import com.jlu.magmalab.dao.tables.records.TmUserRecord;
import com.jlu.magmalab.dao.tables.records.TmUserRoleRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>magmLab</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TmDistributeValueRecord> KEY_TM_DISTRIBUTE_VALUE_PRIMARY = UniqueKeys0.KEY_TM_DISTRIBUTE_VALUE_PRIMARY;
    public static final UniqueKey<TmMeltTypeRecord> KEY_TM_MELT_TYPE_PRIMARY = UniqueKeys0.KEY_TM_MELT_TYPE_PRIMARY;
    public static final UniqueKey<TmMixTypeRecord> KEY_TM_MIX_TYPE_PRIMARY = UniqueKeys0.KEY_TM_MIX_TYPE_PRIMARY;
    public static final UniqueKey<TmMixValueRecord> KEY_TM_MIX_VALUE_PRIMARY = UniqueKeys0.KEY_TM_MIX_VALUE_PRIMARY;
    public static final UniqueKey<TmRoleRecord> KEY_TM_ROLE_PRIMARY = UniqueKeys0.KEY_TM_ROLE_PRIMARY;
    public static final UniqueKey<TmStdTypeRecord> KEY_TM_STD_TYPE_PRIMARY = UniqueKeys0.KEY_TM_STD_TYPE_PRIMARY;
    public static final UniqueKey<TmStdValueRecord> KEY_TM_STD_VALUE_PRIMARY = UniqueKeys0.KEY_TM_STD_VALUE_PRIMARY;
    public static final UniqueKey<TmUserRecord> KEY_TM_USER_PRIMARY = UniqueKeys0.KEY_TM_USER_PRIMARY;
    public static final UniqueKey<TmUserRoleRecord> KEY_TM_USER_ROLE_PRIMARY = UniqueKeys0.KEY_TM_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<TmDistributeValueRecord> KEY_TM_DISTRIBUTE_VALUE_PRIMARY = createUniqueKey(TmDistributeValue.TM_DISTRIBUTE_VALUE, "KEY_TM_DISTRIBUTE_VALUE_PRIMARY", TmDistributeValue.TM_DISTRIBUTE_VALUE.ELE_NAME, TmDistributeValue.TM_DISTRIBUTE_VALUE.MINERAL_ID, TmDistributeValue.TM_DISTRIBUTE_VALUE.MELT_TYPE);
        public static final UniqueKey<TmMeltTypeRecord> KEY_TM_MELT_TYPE_PRIMARY = createUniqueKey(TmMeltType.TM_MELT_TYPE, "KEY_TM_MELT_TYPE_PRIMARY", TmMeltType.TM_MELT_TYPE.MELT_TYPE);
        public static final UniqueKey<TmMixTypeRecord> KEY_TM_MIX_TYPE_PRIMARY = createUniqueKey(TmMixType.TM_MIX_TYPE, "KEY_TM_MIX_TYPE_PRIMARY", TmMixType.TM_MIX_TYPE.MIX_ID, TmMixType.TM_MIX_TYPE.MIX_NAME);
        public static final UniqueKey<TmMixValueRecord> KEY_TM_MIX_VALUE_PRIMARY = createUniqueKey(TmMixValue.TM_MIX_VALUE, "KEY_TM_MIX_VALUE_PRIMARY", TmMixValue.TM_MIX_VALUE.ELE_NAME, TmMixValue.TM_MIX_VALUE.MIX_ID);
        public static final UniqueKey<TmRoleRecord> KEY_TM_ROLE_PRIMARY = createUniqueKey(TmRole.TM_ROLE, "KEY_TM_ROLE_PRIMARY", TmRole.TM_ROLE.ROLE_ID);
        public static final UniqueKey<TmStdTypeRecord> KEY_TM_STD_TYPE_PRIMARY = createUniqueKey(TmStdType.TM_STD_TYPE, "KEY_TM_STD_TYPE_PRIMARY", TmStdType.TM_STD_TYPE.STD_ID);
        public static final UniqueKey<TmStdValueRecord> KEY_TM_STD_VALUE_PRIMARY = createUniqueKey(TmStdValue.TM_STD_VALUE, "KEY_TM_STD_VALUE_PRIMARY", TmStdValue.TM_STD_VALUE.ELE_NAME);
        public static final UniqueKey<TmUserRecord> KEY_TM_USER_PRIMARY = createUniqueKey(TmUser.TM_USER, "KEY_TM_USER_PRIMARY", TmUser.TM_USER.USER_ID);
        public static final UniqueKey<TmUserRoleRecord> KEY_TM_USER_ROLE_PRIMARY = createUniqueKey(TmUserRole.TM_USER_ROLE, "KEY_TM_USER_ROLE_PRIMARY", TmUserRole.TM_USER_ROLE.USER_ID);
    }
}
