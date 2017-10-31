package org.hospital.service;

import java.util.List;

import org.hospital.domain.Project;


/**
 * Created by pismery on 2017-10-25.
 */
public interface ProjectService {

    Project getById(Long id);
    
    List<Project> getAll();
    
    List<Project> getTreatmentProject();
    
    List<Project> getFundProject();
}
