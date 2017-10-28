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
 * Position entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.hospital.domain.Position
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class PositionDAO {
	private static final Logger log = LoggerFactory.getLogger(PositionDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String RANK = "rank";

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

	public void save(Position transientInstance) {
		log.debug("saving Position instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Position persistentInstance) {
		log.debug("deleting Position instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Position findById(java.lang.Integer id) {
		log.debug("getting Position instance with id: " + id);
		try {
			Position instance = (Position) getCurrentSession().get("org.hospital.domain.Position",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Position> findByExample(Position instance) {
		log.debug("finding Position instance by example");
		try {
			List<Position> results = (List<Position>) getCurrentSession()
					.createCriteria("org.hospital.domain.Position").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Position instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Position as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Position> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Position> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Position> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List findAll() {
		log.debug("finding all Position instances");
		try {
			String queryString = "from Position";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Position merge(Position detachedInstance) {
		log.debug("merging Position instance");
		try {
			Position result = (Position) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Position instance) {
		log.debug("attaching dirty Position instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Position instance) {
		log.debug("attaching clean Position instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PositionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PositionDAO) ctx.getBean("PositionDAO");
	}
}