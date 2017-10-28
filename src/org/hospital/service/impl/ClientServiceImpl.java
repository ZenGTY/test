package org.hospital.service.impl;

import org.hospital.domain.Client;
import org.hospital.domain.ClientDAO;
import org.hospital.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO cdao;

	@Override
	public Client getById(Long id) {
		return cdao.findById(id);
	}

	@Override
	public Client addEntity(Client client) {
		return cdao.merge(client);
	}

	@Override
	public Client saveEntity(Client client) {
		return cdao.merge(client);
	}
    
    
}
