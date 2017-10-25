package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.ClientDao;
import org.hospital.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */


@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    private static final Logger log = LoggerFactory.getLogger(BillDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void save(Client entity) {
        log.debug("ClientDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("ClientDao save successful");
        } catch (RuntimeException re) {
            log.error("ClientDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(Client entity) {
        log.debug("ClientDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("ClientDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("ClientDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("ClientDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("ClientDao delete successful");
        } catch (RuntimeException re) {
            log.error("ClientDao delete error:", re);
            throw re;
        }
    }

    public Client get(Long id) {
        log.debug("ClientDao get");
        try {
            Client client = getCurrentSession().get(Client.class, id);
            log.debug("ClientDao get successful,id：" + client.getClientId());
            return client;
        } catch (RuntimeException re) {
            log.error("ClientDao get error:", re);
            throw re;
        }
    }

    public Client load(Long id) {
        log.debug("ClientDao load");
        try {
            Client client = getCurrentSession().load(Client.class, id);
            log.debug("ClientDao load successful,id：" + client.getClientId());
            return client;
        } catch (RuntimeException re) {
            log.error("ClientDao load error:", re);
            throw re;
        }
    }

    public Client merge(Client entity) {
        log.debug("ClientDao merge");
        try {
            Client client = (Client)getCurrentSession().merge(entity);
            log.debug("ClientDao merge successful,id：" + client.getClientId());
            return client;
        } catch (RuntimeException re) {
            log.error("ClientDao merge error:", re);
            throw re;
        }
    }

    public List<Client> getAll() {
        log.debug("finding all Client instances");
        try {
            String queryString = "from client";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Client> findByProperty(String propertyName, Object value) {
        log.debug("finding Client instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from client as model where model."
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
