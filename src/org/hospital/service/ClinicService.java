package org.hospital.service;

import java.util.List;

import org.hospital.domain.Clinic;

/**
 * Created by pismery on 2017-10-25.
 */
public interface ClinicService {
	
	/**
     * 根据Id获取Clinic对象
     * @param pk
     * @return
     */
	Clinic getById(Integer id);

    /**
     * save将Clinic对象写入数据库
     * @param entity
     */
	Clinic addEntity(Clinic entity);

    /**
     * 更新Clinic对象至数据库
     * @param entity
     * @return
     */
	Clinic updateEntity(Clinic entity);
	
	List<Clinic> getAll();

}
