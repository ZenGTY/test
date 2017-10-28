package org.hospital.service.impl;

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
}
