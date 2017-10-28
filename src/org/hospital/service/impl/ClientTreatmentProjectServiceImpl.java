package org.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hospital.domain.ClientTreatmentProject;
import org.hospital.domain.ClientTreatmentProjectDAO;
import org.hospital.service.ClientTreatmentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class ClientTreatmentProjectServiceImpl implements ClientTreatmentProjectService{
	
	@Autowired
	ClientTreatmentProjectDAO ctpDao;
	
	@Override
	public ClientTreatmentProject getById(Long id) {
		return ctpDao.findById(id);
	}

	@Override
	public ClientTreatmentProject addEntity(ClientTreatmentProject entity) {
		return ctpDao.merge(entity);
	}

	@Override
	public ClientTreatmentProject updateEntity(ClientTreatmentProject entity) {
		return ctpDao.merge(entity);
	}

	@Override
	public List<ClientTreatmentProject> addEntityList(List<ClientTreatmentProject> list) {
		List<ClientTreatmentProject> result = new ArrayList<ClientTreatmentProject>();
		for (int i = 0; i < list.size(); i++) {
			result.add(addEntity(list.get(i)));
		}
		return result;
	}
	
}
