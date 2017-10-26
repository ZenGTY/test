package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.RecordDao;
import org.hospital.entity.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class RecordDaoImpl implements RecordDao {
    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String CATEGORY = "complain";
    public static final String PRESENT_ILLNESS = "presentIllness";
    public static final String PAST_ILLNESS = "pastIllness";
    public static final String PHYSICAL_EXAMINATION = "physicalExamination";
    public static final String BASIS = "basis";
    public static final String ANTIDIASTOLE = "antidiastole";
    public static final String PRELIMINARY_DIAGNSIS = "preliminaryDiagnosis";
    public static final String DIANOSIS_PLAN = "diagnosisPlan";
    public static final String TREATMENT_PLAN = "treatmentPlan";
    public static final String CREATE_TIME = "createTime";

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Record entity) {
        log.debug("RecordDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("RecordDao save successful");
        } catch (RuntimeException re) {
            log.error("RecordDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Record entity) {
        log.debug("RecordDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("RecordDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("RecordDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("RecordDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("RecordDao delete successful");
        } catch (RuntimeException re) {
            log.error("RecordDao delete error:", re);
            throw re;
        }
    }

    public Record get(Long id) {
        log.debug("RecordDao get");
        try {
            Record result = getCurrentSession().get(Record.class, id);
            log.debug("RecordDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("RecordDao get error:", re);
            throw re;
        }
    }

    public Record load(Long id) {
        log.debug("RecordDao load");
        try {
            Record result = getCurrentSession().load(Record.class, id);
            log.debug("RecordDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("RecordDao load error:", re);
            throw re;
        }
    }

    public Record merge(Record entity) {
        log.debug("RecordDao merge");
        try {
            Record result = (Record)getCurrentSession().merge(entity);
            log.debug("RecordDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("RecordDao merge error:", re);
            throw re;
        }
    }

    public List<Record> getAll() {
        log.debug("finding all Record instances");
        try {
            String queryString = "from Record";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Record> findByProperty(String propertyName, Object value) {
        log.debug("finding Record instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Record as model where model."
                    + propertyName + "= ?";
            Query queryObject = getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }
}
