package org.hospital.service.impl;

import org.hospital.dao.ClientDao;
import org.hospital.entity.Client;
import org.hospital.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao cdao;

    public Client getClientById(Long id) {
        return cdao.get(id);
    }

    public Client addClient(Client client) {
        return cdao.merge(client);
    }

    public Client saveClient(Client client) {
        return cdao.merge(client);
    }
}
