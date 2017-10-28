package org.hospital.domain;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
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
 * ClientTreatmentInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.hospital.domain.ClientTreatmentInfo
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class ClientTreatmentInfoDAO {
	private static final Logger log = LoggerFactory.getLogger(ClientTreatmentInfoDAO.class);
	// property constants

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

	/**
	 * 获取employeeId 从startTime至endTime的总次数和总价格
	 * 
	 * @param employeeId
	 * @param startTime
	 * @param endTime
	 * @return [[employeeId,employeeName,COUNT,SUM],[]]
	 */
	public List getWorkerReportMsg(Long employeeId, Long startTime, Long endTime) {
		log.debug("getWorkerReportMsg ClientTreatmentInfo instance");
		try {
			String hql = "SELECT ctf.employee.employeeId,COUNT(ctf.clientTreatmentInfoId),SUM(clienttreatmentproject.unitPrice) "
					+ "FROM ClientTreatmentInfo AS ctf "
					+ "WHERE ctf.employee.employeeId = :employeeId "
					+ "AND ctf.treatTime >= :startTime " + "AND ctf.treatTime <= :endTime";
			Query q = getCurrentSession().createQuery(hql);

			q.setBigInteger("employeeId", new BigInteger(employeeId.toString()));
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getWorkerReportMsg failed", re);
			throw re;
		}

	}

	/**
	 * 获取科室在[startTime,endTime]执行治疗总收入
	 * 
	 * @param departmentId
	 * @param startTime
	 * @param endTime
	 * @return [[COUNT,SUM]]
	 */
	public List getDepartmentSumPrice(Integer departmentId, Long startTime, Long endTime) {
		log.debug("getDepartmentSumPrice ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(ctf.clientTreatmentInfoId),SUM(clienttreatmentproject.unitPrice) "
					+ "FROM ClientTreatmentInfo AS ctf "
					+ "WHERE ctf.department.departmentId = :departmentId "
					+ "AND ctf.treatTime >= :startTime " + "AND ctf.treatTime <= :endTime";
			Query q = getCurrentSession().createQuery(hql);

			q.setInteger("departmentId", departmentId);
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getDepartmentSumPrice failed", re);
			throw re;
		}
	}

	/**
	 * 获取门诊在[startTime,endTime]执行治疗总收入
	 * 
	 * @param clinicId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List getClinicSumPrice(Integer clinicId, Long startTime, Long endTime) {
		log.debug("getClinicSumPrice ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(ctf.clientTreatmentInfoId),SUM(clienttreatmentproject.unitPrice) "
					+ "FROM ClientTreatmentInfo AS ctf "
					+ "WHERE ctf.clinic.clinicId = :clinicId "
					+ "AND ctf.treatTime >= :startTime " + "AND ctf.treatTime <= :endTime";
			Query q = getCurrentSession().createQuery(hql);

			q.setInteger("clinicId", clinicId);
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getClinicSumPrice failed", re);
			throw re;
		}
	}

	/**
	 * 获取所有门诊在[startTime,endTime]执行治疗总收入
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List getSumPrice(Long startTime, Long endTime) {
		log.debug("getWorkerReportMsg ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(ctf.clientTreatmentInfoId),SUM(clienttreatmentproject.unitPrice) "
					+ "FROM ClientTreatmentInfo AS ctf "
					+ "WHERE ctf.treatTime >= :startTime "
					+ "AND ctf.treatTime <= :endTime";
			Query q = getCurrentSession().createQuery(hql);

			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getWorkerReportMsg failed", re);
			throw re;
		}
	}

	public void save(ClientTreatmentInfo transientInstance) {
		log.debug("saving ClientTreatmentInfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {

		}
	}

	public void delete(ClientTreatmentInfo persistentInstance) {
		log.debug("deleting ClientTreatmentInfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClientTreatmentInfo findById(java.lang.Long id) {
		log.debug("getting ClientTreatmentInfo instance with id: " + id);
		try {
			ClientTreatmentInfo instance = (ClientTreatmentInfo) getCurrentSession().get(
					"org.hospital.domain.ClientTreatmentInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ClientTreatmentInfo> findByExample(ClientTreatmentInfo instance) {
		log.debug("finding ClientTreatmentInfo instance by example");
		try {
			List<ClientTreatmentInfo> results = (List<ClientTreatmentInfo>) getCurrentSession()
					.createCriteria("org.hospital.domain.ClientTreatmentInfo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ClientTreatmentInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ClientTreatmentInfo as model where model." + propertyName
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
		log.debug("finding all ClientTreatmentInfo instances");
		try {
			String queryString = "from ClientTreatmentInfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClientTreatmentInfo merge(ClientTreatmentInfo detachedInstance) {
		log.debug("merging ClientTreatmentInfo instance");
		try {
			ClientTreatmentInfo result = (ClientTreatmentInfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientTreatmentInfo instance) {
		log.debug("attaching dirty ClientTreatmentInfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientTreatmentInfo instance) {
		log.debug("attaching clean ClientTreatmentInfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientTreatmentInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientTreatmentInfoDAO) ctx.getBean("ClientTreatmentInfoDAO");
	}
}