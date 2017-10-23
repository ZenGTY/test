package org.hospital.service;


import org.hospital.entity.ClientEntity;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface ClientService {
    /**
     * 直接获取client持久化对象
     * @param id
     * @return
     */
    ClientEntity get(Integer id);

    /**
     * 保存client对象至数据库并升级为持久态
     * @param client
     * @return client对象对应主键
     */
    Integer save(ClientEntity client);
}
