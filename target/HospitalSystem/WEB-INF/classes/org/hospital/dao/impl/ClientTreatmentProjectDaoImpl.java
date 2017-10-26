package org.hospital.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hospital.dao.ClientTreatmentProjectDao;
import org.hospital.entity.ClientTreatmentProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
public class ClientTreatmentProjectDaoImpl implements ClientTreatmentProjectDao{

    private static final Logger log = LoggerFactory.getLogger(BillProjectDaoImpl.class);

    public static final String UNIT_PRICE = "unitPrice";
    public static final String TOTAL_NUMBER = "totalNumber";
    public static final String REST_NUMBER = "restNumber";
    public static final String START_TIME = "startTime";
    public static final String DEADLINE = "deadline";
    public static final String STATUS = "status";

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void save(ClientTreatmentProject entity) {
        log.debug("ClientTreatmentProjectDao save");
        try {
            getCurrentSession().save(entity);
            log.debug("ClientTreatmentProjectDao save successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao save error:", re);
            throw re;
        }
    }

    public void saveOrUpdate(ClientTreatmentProject entity) {
        log.debug("ClientTreatmentProjectDao saveOrUpdate");
        try {
            getCurrentSession().saveOrUpdate(entity);
            log.debug("ClientTreatmentProjectDao saveOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao saveOrUpdate error:", re);
            throw re;
        }
    }

    public void delete(Long id) {
        log.debug("ClientTreatmentProjectDao delete");
        try {
            getCurrentSession().saveOrUpdate(get(id));
            log.debug("ClientTreatmentProjectDao delete successful");
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao delete error:", re);
            throw re;
        }
    }

    public ClientTreatmentProject get(Long id) {
        log.debug("ClientTreatmentProjectDao get");
        try {
            ClientTreatmentProject clientTreatmentProject = getCurrentSession().get(ClientTreatmentProject.class, id);
            log.debug("ClientTreatmentProjectDao get successful：" + clientTreatmentProject);
            return clientTreatmentProject;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao get error:", re);
            throw re;
        }
    }

    public ClientTreatmentProject load(Long id) {
        log.debug("ClientTreatmentProjectDao load");
        try {
            ClientTreatmentProject clientTreatmentProject = getCurrentSession().load(ClientTreatmentProject.class, id);
            log.debug("ClientTreatmentProjectDao load successful：" + clientTreatmentProject);
            return clientTreatmentProject;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao load error:", re);
            throw re;
        }
    }

    public ClientTreatmentProject merge(ClientTreatmentProject entity) {
        log.debug("ClientTreatmentProjectDao merge");
        try {
            ClientTreatmentProject clientTreatmentProject = (ClientTreatmentProject)getCurrentSession().merge(entity);
            log.debug("ClientTreatmentProjectDao merge successful：" + clientTreatmentProject);
            return clientTreatmentProject;
        } catch (RuntimeException re) {
            log.error("ClientTreatmentProjectDao merge error:", re);
            throw re;
        }
    }

    public List<ClientTreatmentProject> getAll() {
        log.debug("finding all ClientTreatmentProject instances");
        try {
            String queryString = "from clientTreatmentProject";
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<ClientTreatmentProject> findByProperty(String propertyName, Object value) {
        log.debug("finding ClientTreatmentProject instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from clientTreatmentProject as model where model."
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
