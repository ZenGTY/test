package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.PermissionDao;
import org.hospital.entity.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class PermissionDaoImpl implements PermissionDao {
    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String NAME = "name";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Permission entity) {
        log.debug("PermissionDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("PermissionDao save successful");
        } catch (RuntimeException re) {
            log.error("PermissionDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Permission entity) {
        log.debug("PermissionDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("PermissionDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("PermissionDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("PermissionDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("PermissionDao delete successful");
        } catch (RuntimeException re) {
            log.error("PermissionDao delete error:", re);
            throw re;
        }
    }

    public Permission get(Integer id) {
        log.debug("PermissionDao get");
        try {
            Permission result = getCurrentSession().get(Permission.class, id);
            log.debug("PermissionDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PermissionDao get error:", re);
            throw re;
        }
    }

    public Permission load(Integer id) {
        log.debug("PermissionDao load");
        try {
            Permission result = getCurrentSession().load(Permission.class, id);
            log.debug("PermissionDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PermissionDao load error:", re);
            throw re;
        }
    }

    public Permission merge(Permission entity) {
        log.debug("PermissionDao merge");
        try {
            Permission result = (Permission)getCurrentSession().merge(entity);
            log.debug("PermissionDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PermissionDao merge error:", re);
            throw re;
        }
    }

    public List<Permission> getAll() {
        log.debug("finding all Permission instances");
        try {
            String queryString = "from Permission";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Permission> findByProperty(String propertyName, Object value) {
        log.debug("finding Permission instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Permission as model where model."
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
