package org.hospital.dao.impl;

import org.hospital.dao.ClientDao;
import org.hospital.entity.ClientEntity;
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
    public Integer save(ClientEntity entity) {
        return null;
    }

    /**
     * 保存或者更新对象至数据库
     *
     * @param entity
     */
    public void saveOrUpdate(ClientEntity entity) {

    }

    public void delete(Integer id) {

    }

    /**
     * 直接获取持久化对象
     *
     * @param id
     * @return
     */
    public ClientEntity get(Integer id) {
        return null;
    }

    /**
     * 延迟获取持久化对象；为使用是知道id的代理对象
     *
     * @param id
     * @return
     */
    public ClientEntity load(Integer id) {
        return null;
    }

    public ClientEntity merge(ClientEntity entity) {
        return null;
    }

    public List<ClientEntity> getAll() {
        return null;
    }
}
