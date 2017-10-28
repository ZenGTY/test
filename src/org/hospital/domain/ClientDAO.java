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
 * Client entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.hospital.domain.Client
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class ClientDAO {
	private static final Logger log = LoggerFactory.getLogger(ClientDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String IDENTITY = "identity";
	public static final String AGE = "age";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String BIRTHPLACE = "birthplace";
	public static final String NATION = "nation";
	public static final String MARRIAGE = "marriage";
	public static final String OCCUPATION = "occupation";
	public static final String COMPANY = "company";
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

	public void save(Client transientInstance) {
		log.debug("saving Client instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Client persistentInstance) {
		log.debug("deleting Client instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Client findById(java.lang.Long id) {
		log.debug("getting Client instance with id: " + id);
		try {
			Client instance = (Client) getCurrentSession().get("org.hospital.domain.Client", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Client> findByExample(Client instance) {
		log.debug("finding Client instance by example");
		try {
			List<Client> results = (List<Client>) getCurrentSession()
					.createCriteria("org.hospital.domain.Client").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Client instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Client as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Client> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Client> findByIdentity(Object identity) {
		return findByProperty(IDENTITY, identity);
	}

	public List<Client> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Client> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Client> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Client> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Client> findByBirthplace(Object birthplace) {
		return findByProperty(BIRTHPLACE, birthplace);
	}

	public List<Client> findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	public List<Client> findByMarriage(Object marriage) {
		return findByProperty(MARRIAGE, marriage);
	}

	public List<Client> findByOccupation(Object occupation) {
		return findByProperty(OCCUPATION, occupation);
	}

	public List<Client> findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List<Client> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Client instances");
		try {
			String queryString = "from Client";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Client merge(Client detachedInstance) {
		log.debug("merging Client instance");
		try {
			Client result = (Client) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Client instance) {
		log.debug("attaching dirty Client instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Client instance) {
		log.debug("attaching clean Client instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientDAO) ctx.getBean("ClientDAO");
	}
}