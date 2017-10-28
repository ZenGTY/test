package org.hospital.service;

import java.util.List;

import org.hospital.domain.BillProject;
import org.hospital.domain.BillProjectId;
import org.hospital.domain.ClientTreatmentProject;

/**
 * Created by pismery on 2017-10-25.
 */
public interface ClientTreatmentProjectService {
	
	
	 /**
     * 根据Id获取ClientTreatmentProject对象
     * @param pk
     * @return
     */
	ClientTreatmentProject getById(Long id);

    /**
     * save将ClientTreatmentProject对象写入数据库
     * @param entity
     */
    ClientTreatmentProject addEntity(ClientTreatmentProject entity);

    /**
     * 更新ClientTreatmentProject对象至数据库
     * @param entity
     * @return
     */
    ClientTreatmentProject updateEntity(ClientTreatmentProject entity);
	/**
     * 将一组ClientTreatmentProject对象写入数据库
     * @param bpList
     * @return
     */
    List<ClientTreatmentProject> addEntityList(List<ClientTreatmentProject> bpList);
}
