package org.hospital.domain;

import java.sql.Timestamp;
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
 * Clinic entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.hospital.domain.Clinic
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class ClinicDAO {
	private static final Logger log = LoggerFactory.getLogger(ClinicDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";

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

	public void save(Clinic transientInstance) {
		log.debug("saving Clinic instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Clinic persistentInstance) {
		log.debug("deleting Clinic instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clinic findById(java.lang.Integer id) {
		log.debug("getting Clinic instance with id: " + id);
		try {
			Clinic instance = (Clinic) getCurrentSession().get("org.hospital.domain.Clinic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Clinic> findByExample(Clinic instance) {
		log.debug("finding Clinic instance by example");
		try {
			List<Clinic> results = (List<Clinic>) getCurrentSession()
					.createCriteria("org.hospital.domain.Clinic").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Clinic instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Clinic as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Clinic> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Clinic> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Clinic> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findAll() {
		log.debug("finding all Clinic instances");
		try {
			String queryString = "from Clinic";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clinic merge(Clinic detachedInstance) {
		log.debug("merging Clinic instance");
		try {
			Clinic result = (Clinic) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Clinic instance) {
		log.debug("attaching dirty Clinic instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clinic instance) {
		log.debug("attaching clean Clinic instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClinicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClinicDAO) ctx.getBean("ClinicDAO");
	}
}