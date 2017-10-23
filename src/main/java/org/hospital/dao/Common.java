package org.hospital.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface Common<T, PK extends Serializable> {


    /**
     * 1、当我们使用update的时候，执行完成后，我们提供的对象A的状态变成持久化状态。
     　　但当我们使用merge的时候，执行完成，我们提供的对象A还是脱管状态，hibernate或者new了一个B，或者检索到 一个持久对象B，并把我们提供的对象A的所有的值拷贝到这个B，执行完成后B是持久状态，而我们提供的A还是托管状态；
     */


    /**
     * 保存entity对象至数据库，并将对象转为持久化对象
     *
     * @param entity
     * @return 保存对象表中对应的主键
     */
    PK save(T entity);

    /**
     * 保存或者更新对象至数据库
     *
     * @param entity
     */
    void saveOrUpdate(T entity);

    /**
     * 删除指定数据
     *
     * @param id 主键
     */
    void delete(PK id);

    /**
     * 直接获取持久化对象
     *
     * @param id 主键
     * @return
     */
    T get(PK id);

    /**
     * 延迟获取持久化对象;
     *
     * @param id 主键
     * @return
     */
    T load(PK id);

    /**
     * @param entity
     * @return
     */
    T merge(T entity);

    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> getAll();

}
