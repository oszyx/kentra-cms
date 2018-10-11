package com.kentrasoft.cms.base.plugin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 描述：用于分页数据参数封装
 *
 * @author zmk
 * @date 2018-8-15
 * @param <T>
 */
public class PageForm<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    /**检索条件*/
    private HashMap<String, Object> pageData;
    /**当前是第几页*/
    private Integer page = 1;
    /**每页显示多少条*/
    private Integer limit=10;

    /**数据*/
    private List<T> data;
    /**总条数*/
    private Integer count=0;
    /**状态码*/
    private Integer code = 0;
    /**返回信息*/
    private String msg ;

    public HashMap<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(HashMap<String, Object> pageData) {
        this.pageData = pageData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit==null||limit<1) {
            limit = Integer.MAX_VALUE;
        }
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page==null||page<1) {
            page = 1;
        }
        this.page = page;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
