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
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.hospital.domain.Employee
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class EmployeeDAO {
	private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);
	// property constants
	public static final String ACCOUNT = "account";
	public static final String PWD = "pwd";
	public static final String NAME = "name";
	public static final String IDENTITY = "identity";
	public static final String AGE = "age";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String BIRTHPLACE = "birthplace";
	public static final String NATION = "nation";
	public static final String MARRIAGE = "marriage";
	public static final String BILL_COST = "billCost";
	public static final String STATUS = "status";
	public static final String IS_ON_JOB = "isOnJob";

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
	 * 
	 * @param propertyName 字段名称
	 * @param value  字段值
	 * @param position  职位
	 * @return
	 */
	public List<Employee> getDoctorByProperty(String propertyName, Object value, Position position) {
		log.debug("EmployeeDao getDepartmentDoctor");
		try {
			String hql = "FROM Employee as e WHERE e.position = :position AND e." + propertyName
					+ " = :property";
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("position", position);
			query.setParameter("property", value);
			List<Employee> result = query.list();
			log.debug("EmployeeDao getDepartmentDoctor successful");
			return result;
		} catch (RuntimeException re) {
			log.error("EmployeeDao getDepartmentDoctor error:", re);
			throw re;
		}
	}

	public List<Employee> getByAccountAndPwd(String account, String pwd) {
		log.debug("EmployeeDao getByAccountAndPwd");
		try {
			String hql = "from Employee as e where e.account = :account and e.pwd = :pwd";
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("account", account);
			query.setParameter("pwd", pwd);
			List<Employee> result = query.list();
			log.debug("EmployeeDao getByAccountAndPwd successful");
			return result;
		} catch (RuntimeException re) {
			log.error("EmployeeDao getByAccountAndPwd error:", re);
			throw re;
		}
	}

	public void save(Employee transientInstance) {
		log.debug("saving Employee instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employee persistentInstance) {
		log.debug("deleting Employee instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employee findById(java.lang.Long id) {
		log.debug("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) getCurrentSession().get("org.hospital.domain.Employee",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Employee> findByExample(Employee instance) {
		log.debug("finding Employee instance by example");
		try {
			List<Employee> results = (List<Employee>) getCurrentSession()
					.createCriteria("org.hospital.domain.Employee").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Employee instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Employee as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Employee> findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List<Employee> findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List<Employee> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Employee> findByIdentity(Object identity) {
		return findByProperty(IDENTITY, identity);
	}

	public List<Employee> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Employee> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Employee> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Employee> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Employee> findByBirthplace(Object birthplace) {
		return findByProperty(BIRTHPLACE, birthplace);
	}

	public List<Employee> findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	public List<Employee> findByMarriage(Object marriage) {
		return findByProperty(MARRIAGE, marriage);
	}

	public List<Employee> findByBillCost(Object billCost) {
		return findByProperty(BILL_COST, billCost);
	}

	public List<Employee> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Employee> findByIsOnJob(Object isOnJob) {
		return findByProperty(IS_ON_JOB, isOnJob);
	}

	public List findAll() {
		log.debug("finding all Employee instances");
		try {
			String queryString = "from Employee";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Employee merge(Employee detachedInstance) {
		log.debug("merging Employee instance");
		try {
			Employee result = (Employee) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Employee instance) {
		log.debug("attaching dirty Employee instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employee instance) {
		log.debug("attaching clean Employee instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmployeeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmployeeDAO) ctx.getBean("EmployeeDAO");
	}
}