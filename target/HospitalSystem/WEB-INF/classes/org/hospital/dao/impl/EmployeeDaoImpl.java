package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.EmployeeDao;
import org.hospital.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "pwd";
    public static final String NAME = "name";
    public static final String IDENTITY = "identity";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    public static final String BIRTHDATE = "birthdate";
    public static final String BIRTHPLACE = "birthplace";
    public static final String NATION = "nation";
    public static final String MARRIAGE = "marriage";
    public static final String BILL_COST = "billCost";
    public static final String IS_ONJOB = "isOnJob";
    public static final String LOGIN_TIME = "loginTime";
    public static final String STATUS = "status";
    public static final String REGISTER_TIME = "registerTime";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void save(Employee entity) {
        log.debug("EmployeeDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("EmployeeDao save successful");
        } catch (RuntimeException re) {
            log.error("EmployeeDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Employee entity) {
        log.debug("EmployeeDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("EmployeeDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("EmployeeDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("EmployeeDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("EmployeeDao delete successful");
        } catch (RuntimeException re) {
            log.error("EmployeeDao delete error:", re);
            throw re;
        }
    }

    public Employee get(Long id) {
        log.debug("EmployeeDao get");
        try {
            Employee result = getCurrentSession().get(Employee.class, id);
            log.debug("EmployeeDao get successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("EmployeeDao get error:", re);
            throw re;
        }
    }

    public Employee load(Long id) {
        log.debug("EmployeeDao load");
        try {
            Employee result = getCurrentSession().load(Employee.class, id);
            log.debug("EmployeeDao load successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("EmployeeDao load error:", re);
            throw re;
        }
    }

    public Employee merge(Employee entity) {
        log.debug("EmployeeDao merge");
        try {
            Employee result = (Employee)getCurrentSession().merge(entity);
            log.debug("EmployeeDao merge successful：" + result);
            return result;
        } catch (RuntimeException re) {
            log.error("EmployeeDao merge error:", re);
            throw re;
        }
    }

    public List<Employee> getAll() {
        log.debug("finding all Employee instances");
        try {
            String queryString = "from Employee";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Employee> findByProperty(String propertyName, Object value) {
        log.debug("finding Employee instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Employee as model where model."
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
