package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.ClientTreatmentInfoDao;
import org.hospital.entity.ClientTreatmentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class ClientTreatmentInfoDaoImpl implements ClientTreatmentInfoDao {

    private static final Logger log = LoggerFactory.getLogger(BillProjectDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(ClientTreatmentInfo entity) {
        log.debug("ClientTreatmentInfoDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("ClientTreatmentInfoDao save successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(ClientTreatmentInfo entity) {
        log.debug("ClientTreatmentInfoDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("ClientTreatmentInfoDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("ClientTreatmentInfoDao delete");
        try {
            getCurrentSession().delete(get(id));
            log.debug("ClientTreatmentInfoDao delete successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao delete error:", re);
            throw re;
        }
    }

    public ClientTreatmentInfo get(Long id) {
        log.debug("ClientTreatmentInfoDao get");
        try {
            ClientTreatmentInfo clientTreatmentInfo = getCurrentSession().get(ClientTreatmentInfo.class, id);
            log.debug("ClientTreatmentInfoDao get successful：" + clientTreatmentInfo);
            return clientTreatmentInfo;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao get error:", re);
            throw re;
        }
    }

    public ClientTreatmentInfo load(Long id) {
        log.debug("ClientTreatmentInfoDao load");
        try {
            ClientTreatmentInfo clientTreatmentInfo = getCurrentSession().load(ClientTreatmentInfo.class, id);
            log.debug("ClientTreatmentInfoDao load successful：" + clientTreatmentInfo);
            return clientTreatmentInfo;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao load error:", re);
            throw re;
        }
    }

    public ClientTreatmentInfo merge(ClientTreatmentInfo entity) {
        log.debug("ClientTreatmentInfoDao load");
        try {
            ClientTreatmentInfo clientTreatmentInfo = (ClientTreatmentInfo)getCurrentSession().merge(entity);
            log.debug("ClientTreatmentInfoDao load successful：" + clientTreatmentInfo);
            return clientTreatmentInfo;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentInfoDao load error:", re);
            throw re;
        }
    }

    public List<ClientTreatmentInfo> getAll() {
        log.debug("finding all ClientTreatmentInfo instances");
        try {
            String queryString = "from clientTreatmentInfo";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<ClientTreatmentInfo> findByProperty(String propertyName, Object value) {
        log.debug("finding ClientTreatmentInfo instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from clientTreatmentInfo as model where model."
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
