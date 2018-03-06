/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.daos;


import com.jlu.magmalab.dao.tables.TmMeltType;
import com.jlu.magmalab.dao.tables.records.TmMeltTypeRecord;

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
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmMeltTypeDao extends DAOImpl<TmMeltTypeRecord, com.jlu.magmalab.dao.tables.pojos.TmMeltType, Integer> {

    /**
     * Create a new TmMeltTypeDao without any configuration
     */
    public TmMeltTypeDao() {
        super(TmMeltType.TM_MELT_TYPE, com.jlu.magmalab.dao.tables.pojos.TmMeltType.class);
    }

    /**
     * Create a new TmMeltTypeDao with an attached configuration
     */
    public TmMeltTypeDao(Configuration configuration) {
        super(TmMeltType.TM_MELT_TYPE, com.jlu.magmalab.dao.tables.pojos.TmMeltType.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.jlu.magmalab.dao.tables.pojos.TmMeltType object) {
        return object.getMeltType();
    }

    /**
     * Fetch records that have <code>MELT_NAME IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmMeltType> fetchByMeltName(String... values) {
        return fetch(TmMeltType.TM_MELT_TYPE.MELT_NAME, values);
    }

    /**
     * Fetch records that have <code>MELT_TYPE IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmMeltType> fetchByMeltType(Integer... values) {
        return fetch(TmMeltType.TM_MELT_TYPE.MELT_TYPE, values);
    }

    /**
     * Fetch a unique record that has <code>MELT_TYPE = value</code>
     */
    public com.jlu.magmalab.dao.tables.pojos.TmMeltType fetchOneByMeltType(Integer value) {
        return fetchOne(TmMeltType.TM_MELT_TYPE.MELT_TYPE, value);
    }
}
