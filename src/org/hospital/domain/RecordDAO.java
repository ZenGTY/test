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
 * Record entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.hospital.domain.Record
 * @author MyEclipse Persistence Tools
 */
@Repository
@Transactional
public class RecordDAO {
	private static final Logger log = LoggerFactory.getLogger(RecordDAO.class);
	// property constants
	public static final String COMPLAIN = "complain";
	public static final String PRESENT_ILLNESS = "presentIllness";
	public static final String PAST_ILLNESS = "pastIllness";
	public static final String PHYSICAL_EXAMINATION = "physicalExamination";
	public static final String BASIS = "basis";
	public static final String ANTIDIASTOLE = "antidiastole";
	public static final String PRELIMINARY_DIAGNOSIS = "preliminaryDiagnosis";
	public static final String DIAGNOSIS_PLAN = "diagnosisPlan";
	public static final String TREATMENT_PLAN = "treatmentPlan";

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

	public void save(Record transientInstance) {
		log.debug("saving Record instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Record persistentInstance) {
		log.debug("deleting Record instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Record findById(java.lang.Long id) {
		log.debug("getting Record instance with id: " + id);
		try {
			Record instance = (Record) getCurrentSession().get("org.hospital.domain.Record", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Record> findByExample(Record instance) {
		log.debug("finding Record instance by example");
		try {
			List<Record> results = (List<Record>) getCurrentSession()
					.createCriteria("org.hospital.domain.Record").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Record instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Record as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Record> findByComplain(Object complain) {
		return findByProperty(COMPLAIN, complain);
	}

	public List<Record> findByPresentIllness(Object presentIllness) {
		return findByProperty(PRESENT_ILLNESS, presentIllness);
	}

	public List<Record> findByPastIllness(Object pastIllness) {
		return findByProperty(PAST_ILLNESS, pastIllness);
	}

	public List<Record> findByPhysicalExamination(Object physicalExamination) {
		return findByProperty(PHYSICAL_EXAMINATION, physicalExamination);
	}

	public List<Record> findByBasis(Object basis) {
		return findByProperty(BASIS, basis);
	}

	public List<Record> findByAntidiastole(Object antidiastole) {
		return findByProperty(ANTIDIASTOLE, antidiastole);
	}

	public List<Record> findByPreliminaryDiagnosis(Object preliminaryDiagnosis) {
		return findByProperty(PRELIMINARY_DIAGNOSIS, preliminaryDiagnosis);
	}

	public List<Record> findByDiagnosisPlan(Object diagnosisPlan) {
		return findByProperty(DIAGNOSIS_PLAN, diagnosisPlan);
	}

	public List<Record> findByTreatmentPlan(Object treatmentPlan) {
		return findByProperty(TREATMENT_PLAN, treatmentPlan);
	}

	public List findAll() {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Record merge(Record detachedInstance) {
		log.debug("merging Record instance");
		try {
			Record result = (Record) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Record instance) {
		log.debug("attaching dirty Record instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Record instance) {
		log.debug("attaching clean Record instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RecordDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RecordDAO) ctx.getBean("RecordDAO");
	}
}