package org.hospital.domain;

import java.math.BigInteger;
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
 * A data access object (DAO) providing persistence and search support for Bill
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.hospital.domain.Bill
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class BillDAO {
	private static final Logger log = LoggerFactory.getLogger(BillDAO.class);
	// property constants
	public static final String CATEGORY = "category";
	public static final String TOTAL_COST = "totalCost";
	public static final String TOTAL_PRICE = "totalPrice";
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
	
	/**
	 * 获取employeeId 从startTime至endTime的开单总次数、总价格
	 * 
	 * @param employeeId
	 * @param startTime
	 * @param endTime
	 * @return [[employeeId,employeeName,COUNT,SUM]]
	 */
	public List getDoctorReportMsg(Long employeeId, Long startTime, Long endTime) {
		log.debug("getWorkerReportMsg ClientTreatmentInfo instance");
		try {
			String hql = "SELECT b.employee.employeeId,b.employee.name,COUNT(b.billId),SUM(b.totalPrice) "
					+ "FROM Bill AS b "
					+ "WHERE b.employee.employeeId = :employeeId "
					+ "AND b.datetime >= :startTime " 
					+ "AND b.datetime <= :endTime "
					+ "AND b.category = 'doctorBill'";
			Query q = getCurrentSession().createQuery(hql);
			q.setParameter("employeeId", employeeId);
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
	 * 获取科室在从startTime至endTime的开单总次数、总价格
	 * 
	 * @param employeeId
	 * @param startTime
	 * @param endTime
	 * @return [[COUNT,SUM]]
	 */
	public List getDepartmentDoctorSumPrice(Integer departmentId, Long startTime, Long endTime) {
		log.debug("getDepartmentDoctorSumPrice ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(b.billId),SUM(b.totalPrice) "
					+ "FROM Bill AS b "
					+ "WHERE b.department.departmentId = :departmentId "
					+ "AND b.datetime >= :startTime " 
					+ "AND b.datetime <= :endTime "
					+ "AND b.category = 'doctorBill'";
			Query q = getCurrentSession().createQuery(hql);
			q.setParameter("departmentId", departmentId);
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getDepartmentDoctorSumPrice failed", re);
			throw re;
		}
	}
	
	/**
	 * 获取门诊在从startTime至endTime的开单总次数、总价格
	 * 
	 * @param employeeId
	 * @param startTime
	 * @param endTime
	 * @return [[COUNT,SUM]]
	 */
	public List getClinicDoctorSumPrice(Integer clinicId, Long startTime, Long endTime) {
		log.debug("getClinicDoctorSumPrice ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(b.billId),SUM(b.totalPrice) "
					+ "FROM Bill AS b "
					+ "WHERE b.clinic.clinicId = :clinicId "
					+ "AND b.datetime >= :startTime " 
					+ "AND b.datetime <= :endTime "
					+ "AND b.category = 'doctorBill'";
			Query q = getCurrentSession().createQuery(hql);
			q.setParameter("clinicId", clinicId);
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			
			List result = q.list();

			return result;
		} catch (RuntimeException re) {
			log.error("getClinicDoctorSumPrice failed", re);
			throw re;
		}
	}
	
	/**
	 * 获取所有门诊在从startTime至endTime的开单总次数、总价格
	 * 
	 * @param employeeId
	 * @param startTime
	 * @param endTime
	 * @return [[COUNT,SUM]]
	 */
	public List getAllDoctorSumPrice(Long startTime, Long endTime) {
		log.debug("getClinicDoctorSumPrice ClientTreatmentInfo instance");
		try {
			String hql = "SELECT COUNT(b.billId),SUM(b.totalPrice) "
					+ "FROM Bill AS b "
					+ "WHERE b.datetime >= :startTime " 
					+ "AND b.datetime <= :endTime "
					+ "AND b.category = 'doctorBill'";
			Query q = getCurrentSession().createQuery(hql);
			q.setTimestamp("startTime", new Date(startTime));
			q.setTimestamp("endTime", new Date(endTime));
			
			List result = q.list();
			
			return result;
		} catch (RuntimeException re) {
			log.error("getClinicDoctorSumPrice failed", re);
			throw re;
		}
	}
	
	public void save(Bill transientInstance) {
		log.debug("saving Bill instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bill persistentInstance) {
		log.debug("deleting Bill instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bill findById(java.lang.Long id) {
		log.debug("getting Bill instance with id: " + id);
		try {
			Bill instance = (Bill) getCurrentSession().get("org.hospital.domain.Bill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bill> findByExample(Bill instance) {
		log.debug("finding Bill instance by example");
		try {
			List<Bill> results = (List<Bill>) getCurrentSession()
					.createCriteria("org.hospital.domain.Bill").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bill instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Bill as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bill> findByCategory(Object category) {
		return findByProperty(CATEGORY, category);
	}

	public List<Bill> findByTotalCost(Object totalCost) {
		return findByProperty(TOTAL_COST, totalCost);
	}

	public List<Bill> findByTotalPrice(Object totalPrice) {
		return findByProperty(TOTAL_PRICE, totalPrice);
	}

	public List<Bill> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Bill instances");
		try {
			String queryString = "from Bill";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bill merge(Bill detachedInstance) {
		log.debug("merging Bill instance");
		try {
			Bill result = (Bill) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bill instance) {
		log.debug("attaching dirty Bill instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bill instance) {
		log.debug("attaching clean Bill instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BillDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BillDAO) ctx.getBean("BillDAO");
	}
}