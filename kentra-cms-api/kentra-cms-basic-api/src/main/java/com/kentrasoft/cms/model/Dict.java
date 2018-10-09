package com.kentrasoft.cms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 描述：Dict
 *
 * @author : zmk
 * @date : 2018-09-30
 */
public class Dict implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 字典id
     */
	private Long id;
    /**
     * 字典名称
     */
	private String dictName;
    /**
     * 字典code
     */
	private String dictCode;
    /**
     * 字典排序
     */
	private Integer dictOrder;
    /**
     * 字典父id
     */
	private Long dictPid;
    /**
     * 字典描述
     */
	private String dictDesc;
    /**
     * 字典状态
     */
	private Integer dictStatus;
    /**
     * 是否有子节点
     */
	private Integer hasChild;
    /**
     * 创建人
     */
	private Long creator;
    /**
     * 创建时间
     */
	private java.util.Date createTime;
    /**
     * 修改人
     */
	private Long updator;
    /**
     * 修改时间
     */
	private java.util.Date updateTime;

    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getDictName() {
    	return dictName;
    }

    public void setDictName(String dictName) {
    	this.dictName = dictName;
    }

    public String getDictCode() {
    	return dictCode;
    }

    public void setDictCode(String dictCode) {
    	this.dictCode = dictCode;
    }

    public Integer getDictOrder() {
    	return dictOrder;
    }

    public void setDictOrder(Integer dictOrder) {
    	this.dictOrder = dictOrder;
    }

    public Long getDictPid() {
    	return dictPid;
    }

    public void setDictPid(Long dictPid) {
    	this.dictPid = dictPid;
    }

    public String getDictDesc() {
    	return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
    	this.dictDesc = dictDesc;
    }

    public Integer getDictStatus() {
    	return dictStatus;
    }

    public void setDictStatus(Integer dictStatus) {
    	this.dictStatus = dictStatus;
    }

    public Integer getHasChild() {
    	return hasChild;
    }

    public void setHasChild(Integer hasChild) {
    	this.hasChild = hasChild;
    }

    public Long getCreator() {
    	return creator;
    }

    public void setCreator(Long creator) {
    	this.creator = creator;
    }

    public java.util.Date getCreateTime() {
    	return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
    	this.createTime = createTime;
    }

    public Long getUpdator() {
    	return updator;
    }

    public void setUpdator(Long updator) {
    	this.updator = updator;
    }

    public java.util.Date getUpdateTime() {
    	return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
    	this.updateTime = updateTime;
    }


    private List<Dict> childDicts;

    public List<Dict> getChildDicts() {
        return childDicts;
    }

    public void setChildDicts(List<Dict> childDicts) {
        this.childDicts = childDicts;
    }

    public void addChildDict(Dict childDict) {
        if (this.childDicts==null) {
            this.childDicts = new ArrayList<Dict>();
        }
        this.childDicts.add(childDict);
    }

    public void sameLevelSort() {
        if (childDicts != null && childDicts.size() != 0) {
            Collections.sort(childDicts, new Comparator<Dict>() {
                @Override
                public int compare(Dict d1, Dict d2) {
                    int a = d1.getDictOrder();
                    int b = d2.getDictOrder();
                    return (a < b ? -1 : (a == b ? 0 : 1));
                }
            });
            for (Dict n : childDicts) {
                n.sameLevelSort();
            }
        }
    }
}