package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.BillProjectDao;
import org.hospital.entity.BillProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class BillProjectDaoImpl implements BillProjectDao {

    private static final Logger log = LoggerFactory.getLogger(BillProjectDaoImpl.class);

    public static final String NUMBER = "number";
    public static final String PRICE = "price";
    public static final String DEADLINE = "deadline";
    public static final String EXTRAINFO = "extraInfo";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(BillProject entity) {
        log.debug("BillProjectDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("BillProjectDao save successful");
        } catch (RuntimeException re) {
            log.error("BillProjectDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(BillProject entity) {
        log.debug("BillProjectDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("BillProjectDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("BillProjectDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("BillProjectDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("BillProjectDao delete successful");
        } catch (RuntimeException re) {
            log.error("BillProjectDao delete error:", re);
            throw re;
        }
    }

    public BillProject get(Long id) {
        log.debug("BillProjectDao get");
        try {
            BillProject billProject = getCurrentSession().get(BillProject.class, id);
            log.debug("BillProjectDao get successful：" + billProject);
            return billProject;
        } catch (RuntimeException re) {
            log.error("BillProjectDao get error:", re);
            throw re;
        }
    }

    public BillProject load(Long id) {
        log.debug("BillProjectDao load");
        try {
            BillProject billProject = getCurrentSession().load(BillProject.class, id);
            log.debug("BillProjectDao load successful：" + billProject);
            return billProject;
        } catch (RuntimeException re) {
            log.error("BillProjectDao load error:", re);
            throw re;
        }
    }

    public BillProject merge(BillProject entity) {
        log.debug("BillProjectDao merge");
        try {
            BillProject billProject = (BillProject)getCurrentSession().merge(entity);
            log.debug("BillProjectDao merge successful：" + billProject);
            return billProject;
        } catch (RuntimeException re) {
            log.error("BillProjectDao merge error:", re);
            throw re;
        }
    }

    public List<BillProject> getAll() {
        log.debug("finding all BillProject instances");
        try {
            String queryString = "from billProject";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<BillProject> findByProperty(String propertyName, Object value) {
        log.debug("finding BillProject instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from billProject as model where model."
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
