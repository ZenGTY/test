package org.hospital.service;

import java.util.List;

import org.hospital.domain.Clinic;
import org.hospital.domain.Department;

/**
 * Created by pismery on 2017-10-25.
 */
public interface DepartmentService {
	/**
     * 根据Id获取Department对象
     * @param pk
     * @return
     */
	Department getById(Integer id);

    /**
     * save将Department对象写入数据库
     * @param entity
     */
	Department addEntity(Department entity);

    /**
     * 更新Department对象至数据库
     * @param entity
     * @return
     */
	Department updateEntity(Department entity);
	
	/**
	 * 获取门诊下所有部门
	 * @param clinicId
	 * @return
	 */
	List<Department> getByClinic(Integer clinicId); 
}
