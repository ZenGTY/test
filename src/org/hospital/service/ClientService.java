package org.hospital.service;

import org.hospital.domain.Client;



/**
 * Created by Administrator on 2017/10/12.
 */
public interface ClientService {
    /**
     * 直接获取client持久化对象
     * @param id
     * @return
     */
    Client getById(Long id);

    /**
     * 创建client对象至数据库
     * @param client
     * @return client对象对应主键
     */
    Client addEntity(Client client);

    /**
     * 保存client对象至数据库
     * @param client
     * @return
     */
    Client saveEntity(Client client);

}
