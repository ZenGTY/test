package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.PositionDao;
import org.hospital.entity.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class PositionDaoImpl implements PositionDao {
    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String RANK = "rank";
    public static final String CREATE_TIME = "createTime";

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Position entity) {
        log.debug("PositionDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("PositionDao save successful");
        } catch (RuntimeException re) {
            log.error("PositionDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Position entity) {
        log.debug("PositionDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("PositionDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("PositionDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("PositionDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("PositionDao delete successful");
        } catch (RuntimeException re) {
            log.error("PositionDao delete error:", re);
            throw re;
        }
    }

    public Position get(Integer id) {
        log.debug("PositionDao get");
        try {
            Position result = getCurrentSession().get(Position.class, id);
            log.debug("PositionDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionDao get error:", re);
            throw re;
        }
    }

    public Position load(Integer id) {
        log.debug("PositionDao load");
        try {
            Position result = getCurrentSession().load(Position.class, id);
            log.debug("PositionDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionDao load error:", re);
            throw re;
        }
    }

    public Position merge(Position entity) {
        log.debug("PositionDao merge");
        try {
            Position result = (Position)getCurrentSession().merge(entity);
            log.debug("PositionDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("PositionDao merge error:", re);
            throw re;
        }
    }

    public List<Position> getAll() {
        log.debug("finding all Position instances");
        try {
            String queryString = "from Position";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Position> findByProperty(String propertyName, Object value) {
        log.debug("finding Position instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Position as model where model."
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
