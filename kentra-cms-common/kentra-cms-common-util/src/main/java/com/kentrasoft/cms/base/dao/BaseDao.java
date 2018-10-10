package com.kentrasoft.cms.base.dao;

import java.util.List;
import java.util.Map;

/**
 * 描述：数据接口基础类
 *
 * @author zmk
 * @date 2018-10-08
 */
public interface BaseDao<T,PrimaryKey> {
    /**
     * 描述：插入一个对象
     *
     * @param object 要插入的对象
     * @return id
     */
    PrimaryKey insertObject(T object);


    /**
     * 描述：插入一组对象
     *
     * @param list 对象list
     * @return 影响的行数
     */
    int insertList(List<T> list);


    /**
     * 描述：根据对象主键更新对象所有字段
     *
     * @param object 要更新的对象
     * @return 影响的行数
     */
    int updateAll(T object);

    /**
     * 描述：根据对象主键更新对象不为空字段
     *
     * @param object 要更新的对象
     * @return 影响的行数
     */
    int updateByObject(T object);

    /**
     * 描述：根据对象主键更新对象指定字段
     *
     * @param pageData 要更新的字段
     * @return 影响的行数
     */
    int updateByParams(Map<String, Object> pageData);


    /**
     * 描述：根据id删除对象
     *
     * @param id 主键
     * @return 影响的行数
     */
    int deleteById(PrimaryKey id);


    /**
     * 描述：根据条件删除对象
     *
     * @param pageData 删除条件
     * @return 影响的行数
     */
    int deleteByParams(Map<String, Object> pageData);


    /**
     * 描述：删除一组对象
     *
     * @param IdsStr  主键字符串，如：1,2,3
     * @return 影响的行数
     */
    int deleteByIdsStr(String IdsStr);


    /**
     * 描述：删除一组对象
     *
     * @param ids 主键list
     * @return 影响的行数
     */
    int deleteByIds(List<PrimaryKey> ids);


    /**
     * 描述：根据id获取对象
     *
     * @param id 主键
     * @return 对象
     */
    T findById(PrimaryKey id);


    /**
     * 描述：获取一组对象
     *
     * @param idsStr 主键字符串，如：1,2,3
     * @return 对象List
     */
    List<T> findByIdsStr(String idsStr);


    /**
     * 描述：获取一组对象
     *
     * @param ids 主键List
     * @return 对象List
     */
    List<T> findByIds(List<PrimaryKey> ids);


    /**
     * 描述：查询对象数
     *
     * @param pageData  查询条件
     * @return 符合条件的对象个数
     */
    int queryCountByParams(Map<String, Object> pageData);


    /**
     * 描述：通过条件查询对象列表
     *
     * @param pageData 条件
     * @return 对象列表
     */
    List<T> queryByParams(Map<String, Object> pageData);


    /**
     * 描述：查询所有
     *
     * @return 对象列表
     */
    List<T> findAll();
}
