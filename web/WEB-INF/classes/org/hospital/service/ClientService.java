package org.hospital.service;


import org.hospital.entity.Client;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface ClientService {
    /**
     * 直接获取client持久化对象
     * @param id
     * @return
     */
    Client getClientById(Long id);

    /**
     * 创建client对象至数据库
     * @param client
     * @return client对象对应主键
     */
    Client addClient(Client client);

    /**
     * 保存client对象至数据库
     * @param client
     * @return
     */
    Client saveClient(Client client);

}
