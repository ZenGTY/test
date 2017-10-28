package org.hospital.service;


import java.util.List;

import org.hospital.domain.PositionPermission;

/**
 * Created by pismery on 2017-10-25.
 */
public interface PositionPermissionService {

    List<PositionPermission> getByPostionId(int positionId);
}
