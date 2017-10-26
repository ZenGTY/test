package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.HospitalizationDao;
import org.hospital.entity.Hospitalization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class HospitalizationDaoImpl implements HospitalizationDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String CODE_ICD = "codeIcd";
    public static final String ENTER_DIAGNOSIS = "enterDiagnosis";
    public static final String LEAVE_DIAGNOSIS = "leaveDiagnosis";
    public static final String ENTER_SITUATION = "enterSituation";
    public static final String LEAVE_SITUATION = "leaveSituation";
    public static final String ENTER_TIME = "enterTime";
    public static final String LEAVE_TIME = "leaveTime";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void save(Hospitalization entity) {
        log.debug("HospitalizationDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("HospitalizationDao save successful");
        } catch (RuntimeException re) {
            log.error("HospitalizationDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Hospitalization entity) {
        log.debug("HospitalizationDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("HospitalizationDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("HospitalizationDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("HospitalizationDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("HospitalizationDao delete successful");
        } catch (RuntimeException re) {
            log.error("HospitalizationDao delete error:", re);
            throw re;
        }
    }

    public Hospitalization get(Long id) {
        log.debug("HospitalizationDao get");
        try {
            Hospitalization result = getCurrentSession().get(Hospitalization.class, id);
            log.debug("HospitalizationDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("HospitalizationDao get error:", re);
            throw re;
        }
    }

    public Hospitalization load(Long id) {
        log.debug("HospitalizationDao load");
        try {
            Hospitalization result = getCurrentSession().load(Hospitalization.class, id);
            log.debug("HospitalizationDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("HospitalizationDao load error:", re);
            throw re;
        }
    }

    public Hospitalization merge(Hospitalization entity) {
        log.debug("HospitalizationDao merge");
        try {
            Hospitalization result = (Hospitalization)getCurrentSession().merge(entity);
            log.debug("HospitalizationDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("HospitalizationDao merge error:", re);
            throw re;
        }
    }

    public List<Hospitalization> getAll() {
        log.debug("finding all Hospitalization instances");
        try {
            String queryString = "from Hospitalization";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Hospitalization> findByProperty(String propertyName, Object value) {
        log.debug("finding Hospitalization instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Hospitalization as model where model."
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
