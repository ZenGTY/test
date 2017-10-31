package org.hospital.service.impl;

import java.util.List;

import org.hospital.domain.Project;
import org.hospital.domain.ProjectDAO;
import org.hospital.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO pDao;

    @Override
    public Project getById(Long id) {
        return pDao.findById(id);
    }

	@Override
	public List<Project> getAll() {
		return pDao.findAll();
	}

	@Override
	public List<Project> getTreatmentProject() {
		return pDao.findByProperty("category", "treatmentProject");
	}

	@Override
	public List<Project> getFundProject() {
		return pDao.findByProperty("category", "fundProject");
	}
}
