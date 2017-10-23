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

    /**
     * 直接获取client持久化对象
     *
     * @param id
     * @return
     */
    public Client get(Long id) {
        return cdao.get(id);
    }

    /**
     * 保存client对象至数据库并升级为持久态
     *
     * @param client
     * @return client对象对应主键
     */
    public Long save(Client client) {
        return cdao.save(client);
    }
}
