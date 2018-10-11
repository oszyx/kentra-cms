package com.kentrasoft.cms.base.service.impl;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.base.plugin.PageForm;
import com.kentrasoft.cms.base.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zmk
 * @date 2018-10-08
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T, Object> getModelDao();

    /**
     * 描述：插入一个对象
     *
     * @param object 要插入的对象
     * @return id
     */
    @Override
   public Object insertObject(T object){
        return getModelDao().insertObject(object);
    }


    /**
     * 描述：插入一组对象
     *
     * @param list 对象list
     * @return 影响的行数
     */
    @Override
    public int insertList(List<T> list){
        return getModelDao().insertList(list);
    }


    /**
     * 描述：根据对象主键更新对象所有字段
     *
     * @param object 要更新的对象
     * @return 影响的行数
     */
    @Override
    public int updateAll(T object){
        return getModelDao().updateAll(object);
    }

    /**
     * 描述：根据对象主键更新对象不为空字段
     *
     * @param object 要更新的对象
     * @return 影响的行数
     */
    @Override
    public int updateByObject(T object){
        return getModelDao().updateByObject(object);
    }

    /**
     * 描述：根据对象主键更新对象指定字段
     *
     * @param pageData 要更新的字段
     * @return 影响的行数
     */
    @Override
    public int updateByParams(Map<String, Object> pageData){
        return getModelDao().updateByParams(pageData);
    }


    /**
     * 描述：根据id删除对象
     *
     * @param id 主键
     * @return 影响的行数
     */
    @Override
    public int deleteById(Object id){
        return getModelDao().deleteById(id);
    }


    /**
     * 描述：根据条件删除对象
     *
     * @param pageData 删除条件
     * @return 影响的行数
     */
    @Override
    public int deleteByParams(Map<String, Object> pageData){
        return getModelDao().deleteByParams(pageData);
    }


    /**
     * 描述：删除一组对象
     *
     * @param IdsStr  主键字符串，如：1,2,3
     * @return 影响的行数
     */
    @Override
    public int deleteByIdsStr(String IdsStr){
        return getModelDao().deleteByIdsStr(IdsStr);
    }


    /**
     * 描述：删除一组对象
     *
     * @param ids 主键list
     * @return 影响的行数
     */
    @Override
    public int deleteByIds(List<Object> ids){
        return getModelDao().deleteByIds(ids);
    }


    /**
     * 描述：根据id获取对象
     *
     * @param id 主键
     * @return 对象
     */
    @Override
    public T findById(Object id){
        return getModelDao().findById(id);
    }


    /**
     * 描述：获取一组对象
     *
     * @param idsStr 主键字符串，如：1,2,3
     * @return 对象List
     */
    @Override
    public List<T> findByIdsStr(String idsStr){
        return getModelDao().findByIdsStr(idsStr);
    }


    /**
     * 描述：获取一组对象
     *
     * @param ids 主键List
     * @return 对象List
     */
    @Override
    public List<T> findByIds(List<Object> ids){
        return getModelDao().findByIds(ids);
    }


    /**
     * 描述：查询对象数
     *
     * @param pageData  查询条件
     * @return 符合条件的对象个数
     */
    @Override
    public int queryCountByParams(Map<String, Object> pageData){
        return getModelDao().queryCountByParams(pageData);
    }


    /**
     * 描述：通过条件查询对象列表
     *
     * @param pageData 条件
     * @return 对象列表
     */
    @Override
    public List<T> queryByParams(Map<String, Object> pageData){
        return getModelDao().queryByParams(pageData);
    }


    /**
     * 描述：查询所有
     *
     * @return 对象列表
     */
    @Override
    public List<T> findAll(){
        return getModelDao().findAll();
    }


    /**
     * 描述：查询页面列表
     *
     * @param pf
     * @return
     */
    @Override
    public PageForm<T> queryPageList(PageForm<T> pf) {
        // 查询条件
        HashMap<String, Object> pageData = pf.getPageData();
        //查询所有的数据数量
        int count = getModelDao().queryCountByParams(pageData);
        pf.setCount(count);
        // 当前页

        Integer currrPage = pf.getPage();
        // 每页显示条数 偏移量
        Integer limit = pf.getLimit();
        pageData.put("__size",limit);
        // start
        Integer currNum = (currrPage - 1) * limit;
        pageData.put("__start",currNum);

        List<T> objects =  getModelDao().queryByParams(pageData);
        pf.setData(objects);
        // 查询
        return pf;
    }

}
