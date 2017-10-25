package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.ClinicDao;
import org.hospital.entity.Clinic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class ClinicDaoImpl implements ClinicDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String CREATE_TIME = "createTime";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Clinic entity) {
        log.debug("ClinicDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("ClinicDao save successful");
        } catch (RuntimeException re) {
            log.error("ClinicDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Clinic entity) {
        log.debug("ClinicDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("ClinicDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("ClinicDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("ClinicDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("ClinicDao delete successful");
        } catch (RuntimeException re) {
            log.error("ClinicDao delete error:", re);
            throw re;
        }
    }

    public Clinic get(Integer id) {
        log.debug("ClinicDao get");
        try {
            Clinic clinic = getCurrentSession().get(Clinic.class, id);
            log.debug("ClinicDao get successful：" + clinic);
            return clinic;
        } catch (RuntimeException re) {
            log.error("ClinicDao get error:", re);
            throw re;
        }
    }

    public Clinic load(Integer id) {
        log.debug("ClinicDao load");
        try {
            Clinic clinic = getCurrentSession().load(Clinic.class, id);
            log.debug("ClinicDao load successful：" + clinic);
            return clinic;
        } catch (RuntimeException re) {
            log.error("ClinicDao load error:", re);
            throw re;
        }
    }

    public Clinic merge(Clinic entity) {
        log.debug("ClinicDao merge");
        try {
            Clinic clinic = (Clinic)getCurrentSession().merge(entity);
            log.debug("ClinicDao merge successful：" + clinic);
            return clinic;
        } catch (RuntimeException re) {
            log.error("ClinicDao merge error:", re);
            throw re;
        }
    }

    public List<Clinic> getAll() {
        log.debug("finding all Clinic instances");
        try {
            String queryString = "from clinic";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Clinic> findByProperty(String propertyName, Object value) {
        log.debug("finding Clinic instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from clinic as model where model."
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
