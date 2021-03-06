/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.daos;


import com.jlu.magmalab.dao.tables.TmBasicDataType;
import com.jlu.magmalab.dao.tables.records.TmBasicDataTypeRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class TmBasicDataTypeDao extends DAOImpl<TmBasicDataTypeRecord, com.jlu.magmalab.dao.tables.pojos.TmBasicDataType, String> {

    /**
     * Create a new TmBasicDataTypeDao without any configuration
     */
    public TmBasicDataTypeDao() {
        super(TmBasicDataType.TM_BASIC_DATA_TYPE, com.jlu.magmalab.dao.tables.pojos.TmBasicDataType.class);
    }

    /**
     * Create a new TmBasicDataTypeDao with an attached configuration
     */
    public TmBasicDataTypeDao(Configuration configuration) {
        super(TmBasicDataType.TM_BASIC_DATA_TYPE, com.jlu.magmalab.dao.tables.pojos.TmBasicDataType.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.jlu.magmalab.dao.tables.pojos.TmBasicDataType object) {
        return object.getDataId();
    }

    /**
     * Fetch records that have <code>DATA_ID IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmBasicDataType> fetchByDataId(String... values) {
        return fetch(TmBasicDataType.TM_BASIC_DATA_TYPE.DATA_ID, values);
    }

    /**
     * Fetch a unique record that has <code>DATA_ID = value</code>
     */
    public com.jlu.magmalab.dao.tables.pojos.TmBasicDataType fetchOneByDataId(String value) {
        return fetchOne(TmBasicDataType.TM_BASIC_DATA_TYPE.DATA_ID, value);
    }

    /**
     * Fetch records that have <code>DATA_NAME IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmBasicDataType> fetchByDataName(String... values) {
        return fetch(TmBasicDataType.TM_BASIC_DATA_TYPE.DATA_NAME, values);
    }

    /**
     * Fetch records that have <code>DATA_TYPE IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmBasicDataType> fetchByDataType(Integer... values) {
        return fetch(TmBasicDataType.TM_BASIC_DATA_TYPE.DATA_TYPE, values);
    }

    /**
     * Fetch records that have <code>MEMO IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmBasicDataType> fetchByMemo(String... values) {
        return fetch(TmBasicDataType.TM_BASIC_DATA_TYPE.MEMO, values);
    }
}
