package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.PostionPermissionDao;
import org.hospital.entity.PostionPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class PostionpermissionDaoImpl implements PostionPermissionDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(PostionPermission entity) {
        log.debug("PostionPermissionDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("PostionPermissionDao save successful");
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(PostionPermission entity) {
        log.debug("PostionPermissionDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("PostionPermissionDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("PostionPermissionDao delete");
        try {
            getCurrentSession().delete(get((id)));
            log.debug("PostionPermissionDao delete successful");
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao delete error:", re);
            throw re;
        }
    }

    public PostionPermission get(Integer id) {
        log.debug("PostionPermissionDao get");
        try {
            PostionPermission result = getCurrentSession().get(PostionPermission.class, id);
            log.debug("PostionPermissionDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao get error:", re);
            throw re;
        }
    }

    public PostionPermission load(Integer id) {
        log.debug("PostionPermissionDao load");
        try {
            PostionPermission result = getCurrentSession().load(PostionPermission.class, id);
            log.debug("PostionPermissionDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao load error:", re);
            throw re;
        }
    }

    public PostionPermission merge(PostionPermission entity) {
        log.debug("PostionPermissionDao merge");
        try {
            PostionPermission result = (PostionPermission)getCurrentSession().merge(entity);
            log.debug("PostionPermissionDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PostionPermissionDao merge error:", re);
            throw re;
        }
    }

    public List<PostionPermission> getAll() {
        log.debug("finding all PostionPermission instances");
        try {
            String queryString = "from PostionPermission";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<PostionPermission> findByProperty(String propertyName, Object value) {
        log.debug("finding PostionPermission instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from PostionPermission as model where model."
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
