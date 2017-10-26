package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.ProjectDao;
import org.hospital.entity.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class ProjectDaoImpl implements ProjectDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String CATEGORY = "category";
    public static final String NAME = "name";
    public static final String UNIT_PRICE = "unitPrice";
    public static final String INTRODUCTION = "introduction";
    public static final String SUGGEST_NUMBER = "suggestNumber";
    public static final String TYPE = "type";
    public static final String STATUS = "status";
    public static final String CREATE_TIME = "createTime";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void save(Project entity) {
        log.debug("ProjectDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("ProjectDao save successful");
        } catch (RuntimeException re) {
            log.error("ProjectDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Project entity) {
        log.debug("ProjectDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("ProjectDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("ProjectDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("ProjectDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("ProjectDao delete successful");
        } catch (RuntimeException re) {
            log.error("ProjectDao delete error:", re);
            throw re;
        }
    }

    public Project get(Long id) {
        log.debug("ProjectDao get");
        try {
            Project result = getCurrentSession().get(Project.class, id);
            log.debug("ProjectDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("ProjectDao get error:", re);
            throw re;
        }
    }

    public Project load(Long id) {
        log.debug("ProjectDao load");
        try {
            Project result = getCurrentSession().load(Project.class, id);
            log.debug("ProjectDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("ProjectDao load error:", re);
            throw re;
        }
    }

    public Project merge(Project entity) {
        log.debug("ProjectDao merge");
        try {
            Project result = (Project)getCurrentSession().merge(entity);
            log.debug("ProjectDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("ProjectDao merge error:", re);
            throw re;
        }
    }

    public List<Project> getAll() {
        log.debug("finding all Project instances");
        try {
            String queryString = "from Project";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Project> findByProperty(String propertyName, Object value) {
        log.debug("finding Project instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Project as model where model."
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
