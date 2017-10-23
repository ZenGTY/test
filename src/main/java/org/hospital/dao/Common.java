package org.hospital.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface Common<T,PK extends Serializable> {
    /**
     * 保存entity对象至数据库，并将对象转为持久化对象
     * @param entity
     * @return 保存对象表中对应的主键
     */
    PK save(T entity);

    /**
     * 保存或者更新对象至数据库
     * @param entity
     */
    void saveOrUpdate(T entity);

    void delete(PK id);

    /**
     * 直接获取持久化对象
     * @param id
     * @return
     */
    T get(PK id);

    /**
     * 延迟获取持久化对象；为使用是知道id的代理对象
     * @param id
     * @return
     */
    T load(PK id);

    T merge(T entity);

    List<T> getAll();

}
