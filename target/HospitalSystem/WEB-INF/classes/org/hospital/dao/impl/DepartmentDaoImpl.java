package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.DepartmentDao;
import org.hospital.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String NAME = "name";
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

    public void save(Department entity) {
        log.debug("DepartmentDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("DepartmentDao save successful");
        } catch (RuntimeException re) {
            log.error("DepartmentDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Department entity) {
        log.debug("DepartmentDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("DepartmentDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("DepartmentDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Integer id) {
        log.debug("DepartmentDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("DepartmentDao delete successful");
        } catch (RuntimeException re) {
            log.error("DepartmentDao delete error:", re);
            throw re;
        }
    }

    public Department get(Integer id) {
        log.debug("DepartmentDao get");
        try {
            Department department = getCurrentSession().get(Department.class, id);
            log.debug("DepartmentDao get successful：" + department);
            return department;
        } catch (RuntimeException re) {
            log.error("DepartmentDao get error:", re);
            throw re;
        }
    }

    public Department load(Integer id) {
        log.debug("DepartmentDao load");
        try {
            Department department = getCurrentSession().load(Department.class, id);
            log.debug("DepartmentDao load successful：" + department);
            return department;
        } catch (RuntimeException re) {
            log.error("DepartmentDao load error:", re);
            throw re;
        }
    }

    public Department merge(Department entity) {
        log.debug("DepartmentDao merge");
        try {
            Department department = (Department)getCurrentSession().merge(entity);
            log.debug("DepartmentDao merge successful：" + department);
            return department;
        } catch (RuntimeException re) {
            log.error("DepartmentDao merge error:", re);
            throw re;
        }
    }

    public List<Department> getAll() {
        log.debug("finding all Department instances");
        try {
            String queryString = "from department";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Department> findByProperty(String propertyName, Object value) {
        log.debug("finding Department instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Department as model where model."
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
