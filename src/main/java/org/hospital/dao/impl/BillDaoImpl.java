package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.BillDao;
import org.hospital.entity.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pismery on 2017-10-24.
 */
@Repository
@Transactional
public class BillDaoImpl implements BillDao {


    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);

    public static final String BILL_ID = "billId";
    public static final String CATEGORY = "category";
    public static final String TOTALCOST = "totalCost";
    public static final String TOTALPRICE = "totalPrice";
    public static final String DATETIME = "datetime";
    public static final String STATUS  = "status";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Bill entity) {
        log.debug("BillDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("BillDao save successful");
        } catch (RuntimeException re) {
            log.error("BillDao save error:", re);
            throw re;
        }
    }


    public void saveOrUpdate(Bill entity) {
        log.debug("BillDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("BillDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("BillDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("BillDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("BillDao delete successful");
        } catch (RuntimeException re) {
            log.error("BillDao delete error:", re);
            throw re;
        }
    }

    public Bill get(Long id) {
        log.debug("BillDao get");
        try {
            Bill bill = getCurrentSession().get(Bill.class, id);
            log.debug("BillDao get successful,id：" + bill.getBillId());
            return bill;
        } catch (RuntimeException re) {
            log.error("BillDao get error:", re);
            throw re;
        }
    }

    public Bill load(Long id) {
        log.debug("BillDao load");
        try {
            Bill bill = getCurrentSession().load(Bill.class, id);
            log.debug("BillDao load successful,id：" + bill.getBillId());
            return bill;
        } catch (RuntimeException re) {
            log.error("BillDao load error:", re);
            throw re;
        }
    }

    public Bill merge(Bill entity) {
        log.debug("BillDao merge");
        try {
            Bill bill = (Bill)getCurrentSession().merge(entity);
            log.debug("BillDao merge successful,id：" + bill.getBillId());
            return bill;
        } catch (RuntimeException re) {
            log.error("BillDao merge error:", re);
            throw re;
        }
    }

    public List<Bill> getAll() {
        log.debug("finding all Bill instances");
        try {
            String queryString = "from bill";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Bill> findByProperty(String propertyName, Object value) {
        log.debug("finding Bill instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from bill as model where model."
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