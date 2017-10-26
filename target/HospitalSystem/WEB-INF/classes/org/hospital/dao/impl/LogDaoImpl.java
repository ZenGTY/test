package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.LogDao;
import org.hospital.entity.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class LogDaoImpl implements LogDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String CONTENT = "content";
    public static final String OPERATE = "operate";
    public static final String OPERATE_TIME = "operateTime";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Log entity) {
        log.debug("LogDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("LogDao save successful");
        } catch (RuntimeException re) {
            log.error("LogDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Log entity) {
        log.debug("LogDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("LogDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("LogDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("LogDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("LogDao delete successful");
        } catch (RuntimeException re) {
            log.error("LogDao delete error:", re);
            throw re;
        }
    }

    public Log get(Long id) {
        log.debug("LogDao get");
        try {
            Log result = getCurrentSession().get(Log.class, id);
            log.debug("LogDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("LogDao get error:", re);
            throw re;
        }
    }

    public Log load(Long id) {
        log.debug("LogDao load");
        try {
            Log result = getCurrentSession().load(Log.class, id);
            log.debug("LogDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("LogDao load error:", re);
            throw re;
        }
    }

    public Log merge(Log entity) {
        log.debug("LogDao merge");
        try {
            Log result = (Log)getCurrentSession().merge(entity);
            log.debug("LogDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("LogDao merge error:", re);
            throw re;
        }
    }

    public List<Log> getAll() {
        log.debug("finding all Log instances");
        try {
            String queryString = "from Log";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Log> findByProperty(String propertyName, Object value) {
        log.debug("finding Log instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Log as model where model."
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
