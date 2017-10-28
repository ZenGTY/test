package org.hospital.domain;

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

import com.alibaba.fastjson.JSON;

/**
 * A data access object (DAO) providing persistence and search support for
 * Positionpermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.hospital.domain.PositionPermission
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class PositionPermissionDAO {
	private static final Logger log = LoggerFactory.getLogger(PositionPermissionDAO.class);
	// property constants
	public static final String POSITION_ID = "positionId";
	public static final String PERMISSION_ID = "permissionId";

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

	public void save(PositionPermission transientInstance) {
		log.debug("saving Positionpermission instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PositionPermission persistentInstance) {
		log.debug("deleting Positionpermission instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PositionPermission findById(org.hospital.domain.PositionPermissionId id) {
		log.debug("getting Positionpermission instance with id: " + id);
		try {
			PositionPermission instance = (PositionPermission) getCurrentSession().get(
					"org.hospital.domain.PositionPermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PositionPermission> findByExample(PositionPermission instance) {
		log.debug("finding Positionpermission instance by example");
		try {
			List<PositionPermission> results = (List<PositionPermission>) getCurrentSession()
					.createCriteria("org.hospital.domain.PositionPermission").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Positionpermission instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PositionPermission as model where model." + propertyName
					+ "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Positionpermission instances");
		try {
			String queryString = "from PositionPermission";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PositionPermission merge(PositionPermission detachedInstance) {
		log.debug("merging PositionPermission instance");
		try {
			PositionPermission result = (PositionPermission) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PositionPermission instance) {
		log.debug("attaching dirty PositionPermission instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PositionPermission instance) {
		log.debug("attaching clean Positionpermission instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PositionPermissionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PositionPermissionDAO) ctx.getBean("PositionpermissionDAO");
	}

	public PositionPermission getByPositionIdAndPermissionName(int positionId, String permissionName) {
		log.info("positionId : " + positionId + "; permissionName : " + permissionName);
		try {
			String hql = "SELECT pp.PositionPermissionId.positionId,pp.PositionPermissionId.permissionId "
					+ "FROM PositionPermission AS pp,Permission AS p "
					+ "WHERE pp.PositionPermissionId.permissionId=p.PositionPermissionId.permissionId "
					+ "AND pp.PositionPermissionId.positionId = :positionId "
					+ "AND p.name = :permissionName";
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("positionId", positionId);
			query.setParameter("permissionName", permissionName);
			List list = query.list();
			if (list == null || list.size() <= 0) {
				return null;
			}
			PositionPermission result = new PositionPermission();

			log.info(JSON.toJSONString(list), true);
			log.debug("PositionPermissionDao getByPositionIdAndPermissionName successful");
			return result;
		} catch (RuntimeException re) {
			log.error("PositionPermissionDao getByPositionIdAndPermissionName error:", re);
			throw re;
		}

	}
}