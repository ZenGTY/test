package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.PositionPermissionDao;
import org.hospital.entity.PositionPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class PositionpermissionDaoImpl implements PositionPermissionDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(PositionPermission entity) {
        log.debug("PositionPermissionDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("PositionPermissionDao save successful");
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(PositionPermission entity) {
        log.debug("PositionPermissionDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("PositionPermissionDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("PositionPermissionDao delete");
        try {
            getCurrentSession().delete(get((id)));
            log.debug("PositionPermissionDao delete successful");
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao delete error:", re);
            throw re;
        }
    }

    public PositionPermission get(Integer id) {
        log.debug("PositionPermissionDao get");
        try {
            PositionPermission result = getCurrentSession().get(PositionPermission.class, id);
            log.debug("PositionPermissionDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao get error:", re);
            throw re;
        }
    }

    public PositionPermission load(Integer id) {
        log.debug("PositionPermissionDao load");
        try {
            PositionPermission result = getCurrentSession().load(PositionPermission.class, id);
            log.debug("PositionPermissionDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao load error:", re);
            throw re;
        }
    }

    public PositionPermission merge(PositionPermission entity) {
        log.debug("PositionPermissionDao merge");
        try {
            PositionPermission result = (PositionPermission)getCurrentSession().merge(entity);
            log.debug("PositionPermissionDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionPermissionDao merge error:", re);
            throw re;
        }
    }

    public List<PositionPermission> getAll() {
        log.debug("finding all PositionPermission instances");
        try {
            String queryString = "from PositionPermission";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<PositionPermission> findByProperty(String propertyName, Object value) {
        log.debug("finding PositionPermission instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from PositionPermission as model where model."
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
