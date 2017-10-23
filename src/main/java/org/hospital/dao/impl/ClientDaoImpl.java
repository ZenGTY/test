package org.hospital.dao.impl;

import org.hospital.dao.ClientDao;
import org.hospital.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */


@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    /**
     * 保存entity对象至数据库，并将对象转为持久化对象
     *
     * @param entity
     * @return 保存对象表中对应的主键
     */
    public Long save(Client entity) {
        return null;
    }

    /**
     * 保存或者更新对象至数据库
     *
     * @param entity
     */
    public void saveOrUpdate(Client entity) {

    }

    public void delete(Long id) {

    }

    /**
     * 直接获取持久化对象
     *
     * @param id
     * @return
     */
    public Client get(Long id) {
        return null;
    }

    /**
     * 延迟获取持久化对象；
     *
     * @param id
     * @return
     */
    public Client load(Long id) {
        return null;
    }

    public Client merge(Client entity) {
        return null;
    }

    public List<Client> getAll() {
        return null;
    }
}
