package org.hospital.domain;

import java.sql.Timestamp;
import java.util.List;

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
 * BillProject entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.hospital.domain.BillProject
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class BillProjectDAO {
	private static final Logger log = LoggerFactory.getLogger(BillProjectDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String PRICE = "price";
	public static final String EXTRA_INFO = "extraInfo";

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

	public List getByBillId(Long billId) {
		log.debug("getByBillId BillProject instance");
		try {
			String hql = "SELECT DISTINCT bp.id.projectId FROM BillProject as bp WHERE bp.id.billId = :billId";
			Query q = getCurrentSession().createQuery(hql);
			q.setParameter("billId", billId);
			List result = q.list();
			log.debug("getByBillId successful");
			return result;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void save(BillProject transientInstance) {
		log.debug("saving BillProject instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BillProject persistentInstance) {
		log.debug("deleting BillProject instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BillProject findById(org.hospital.domain.BillProjectId id) {
		log.debug("getting BillProject instance with id: " + id);
		try {
			BillProject instance = (BillProject) getCurrentSession().get(
					"org.hospital.domain.BillProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BillProject> findByExample(BillProject instance) {
		log.debug("finding BillProject instance by example");
		try {
			List<BillProject> results = (List<BillProject>) getCurrentSession()
					.createCriteria("org.hospital.domain.BillProject").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BillProject instance with property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from BillProject as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BillProject> findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List<BillProject> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<BillProject> findByExtraInfo(Object extraInfo) {
		return findByProperty(EXTRA_INFO, extraInfo);
	}

	public List findAll() {
		log.debug("finding all BillProject instances");
		try {
			String queryString = "from BillProject";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BillProject merge(BillProject detachedInstance) {
		log.debug("merging BillProject instance");
		try {
			BillProject result = (BillProject) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BillProject instance) {
		log.debug("attaching dirty BillProject instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BillProject instance) {
		log.debug("attaching clean BillProject instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BillProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BillProjectDAO) ctx.getBean("BillProjectDAO");
	}
}