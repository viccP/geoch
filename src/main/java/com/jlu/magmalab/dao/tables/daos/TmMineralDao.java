/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.daos;


import com.jlu.magmalab.dao.tables.TmMineral;
import com.jlu.magmalab.dao.tables.records.TmMineralRecord;

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
public class TmMineralDao extends DAOImpl<TmMineralRecord, com.jlu.magmalab.dao.tables.pojos.TmMineral, Integer> {

    /**
     * Create a new TmMineralDao without any configuration
     */
    public TmMineralDao() {
        super(TmMineral.TM_MINERAL, com.jlu.magmalab.dao.tables.pojos.TmMineral.class);
    }

    /**
     * Create a new TmMineralDao with an attached configuration
     */
    public TmMineralDao(Configuration configuration) {
        super(TmMineral.TM_MINERAL, com.jlu.magmalab.dao.tables.pojos.TmMineral.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.jlu.magmalab.dao.tables.pojos.TmMineral object) {
        return object.getIndex();
    }

    /**
     * Fetch records that have <code>INDEX IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmMineral> fetchByIndex(Integer... values) {
        return fetch(TmMineral.TM_MINERAL.INDEX, values);
    }

    /**
     * Fetch a unique record that has <code>INDEX = value</code>
     */
    public com.jlu.magmalab.dao.tables.pojos.TmMineral fetchOneByIndex(Integer value) {
        return fetchOne(TmMineral.TM_MINERAL.INDEX, value);
    }

    /**
     * Fetch records that have <code>MINERAL_NAME IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmMineral> fetchByMineralName(String... values) {
        return fetch(TmMineral.TM_MINERAL.MINERAL_NAME, values);
    }

    /**
     * Fetch records that have <code>MEMO IN (values)</code>
     */
    public List<com.jlu.magmalab.dao.tables.pojos.TmMineral> fetchByMemo(String... values) {
        return fetch(TmMineral.TM_MINERAL.MEMO, values);
    }
}
