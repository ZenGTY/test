package org.hospital.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * ClientTreatmentProject entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.hospital.domain.ClientTreatmentProject
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class ClientTreatmentProjectDAO {
	private static final Logger log = LoggerFactory.getLogger(ClientTreatmentProjectDAO.class);
	// property constants
	public static final String UNIT_PRICE = "unitPrice";
	public static final String TOTAL_NUMBER = "totalNumber";
	public static final String REST_NUMBER = "restNumber";
	public static final String STATUS = "status";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ClientTreatmentProject transientInstance) {
		log.debug("saving ClientTreatmentProject instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ClientTreatmentProject persistentInstance) {
		log.debug("deleting ClientTreatmentProject instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClientTreatmentProject findById(java.lang.Long id) {
		log.debug("getting ClientTreatmentProject instance with id: " + id);
		try {
			ClientTreatmentProject instance = (ClientTreatmentProject) getCurrentSession().get(
					"org.hospital.domain.ClientTreatmentProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ClientTreatmentProject> findByExample(ClientTreatmentProject instance) {
		log.debug("finding ClientTreatmentProject instance by example");
		try {
			List<ClientTreatmentProject> results = (List<ClientTreatmentProject>) getCurrentSession()
					.createCriteria("org.hospital.domain.ClientTreatmentProject")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ClientTreatmentProject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ClientTreatmentProject as model where model." + propertyName
					+ "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ClientTreatmentProject> findByUnitPrice(Object unitPrice) {
		return findByProperty(UNIT_PRICE, unitPrice);
	}

	public List<ClientTreatmentProject> findByTotalNumber(Object totalNumber) {
		return findByProperty(TOTAL_NUMBER, totalNumber);
	}

	public List<ClientTreatmentProject> findByRestNumber(Object restNumber) {
		return findByProperty(REST_NUMBER, restNumber);
	}

	public List<ClientTreatmentProject> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ClientTreatmentProject instances");
		try {
			String queryString = "from ClientTreatmentProject";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClientTreatmentProject merge(ClientTreatmentProject detachedInstance) {
		log.debug("merging ClientTreatmentProject instance");
		try {
			ClientTreatmentProject result = (ClientTreatmentProject) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientTreatmentProject instance) {
		log.debug("attaching dirty ClientTreatmentProject instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientTreatmentProject instance) {
		log.debug("attaching clean ClientTreatmentProject instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientTreatmentProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientTreatmentProjectDAO) ctx.getBean("ClientTreatmentProjectDAO");
	}
}