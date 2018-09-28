package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dict implements Serializable {
	
	/**
	 * Dict
	 */
	private static final long serialVersionUID = 7192595572313978300L;

	/**
	 * 字典ID
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
	 * 字典父级ID
	 */
    private Long dictParentId;
    
	/**
	 * 字典等级
	 */
    private Long dictLevel;
    
	/**
	 * 字典描述
	 */
    private String dictDesc;
    
	/**
	 * 字典状态
	 */
    private Boolean dictStatus;
    
	/**
	 * 字典创建时间
	 */
    private Date createDate;
    
	/**
	 * 字典创建人
	 */
    private String creator;
    
	/**
	 * 字典更新时间
	 */
    private Date updateDate;
    
	/**
	 * 字典更新人
	 */
    private String updator;
    
	/**
	 * 状态
	 */
    private Boolean status;

	private String tbsName;			//关联表
	private String target;
	private Dict dict;
	private List<Dict> children;
	private boolean checked = false;
	private String url;
	private String rel;
	private List<Dict> quasiDrivingType;
	private List<Dict> carType;
	private List<Dict> plateNumPrefix;

    /**
     * 字典ID
     * @return id
     */
	public Long getId() {
		return id;
	}
	
	/**
	 * 字典ID
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 字典名称
	 * @param dictName
	 */
	public String getDictName() {
		return dictName;
	}
	
	/**
	 * 字典名称
	 * @param dictName
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	
	/**
	 * 字典code
	 * @param dictCode
	 */
	public String getDictCode() {
		return dictCode;
	}
	
	/**
	 * 字典code
	 * @param dictCode
	 */
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	
	/**
	 * 字典父级ID
	 * @param dictParentId
	 */
	public Long getDictParentId() {
		return dictParentId;
	}
	
	/**
	 * 字典父级ID
	 * @param dictParentId
	 */
	public void setDictParentId(Long dictParentId) {
		this.dictParentId = dictParentId;
	}

	/**
	 * 字典等级
	 * @param dictLevel
	 */
	public Long getDictLevel() {
		return dictLevel;
	}
	
	/**
	 * 字典等级
	 * @param dictLevel
	 */
	public void setDictLevel(Long dictLevel) {
		this.dictLevel = dictLevel;
	}
	
	/**
	 * 字典描述
	 * @param dictDesc
	 */
	public String getDictDesc() {
		return dictDesc;
	}
	
	/**
	 * 字典描述
	 * @param dictDesc
	 */
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	
	/**
	 * 字典状态
	 * @param dictStatus
	 */
	public Boolean getDictStatus() {
		return dictStatus;
	}
	
	/**
	 * 字典状态
	 * @param dictStatus
	 */
	public void setDictStatus(Boolean dictStatus) {
		this.dictStatus = dictStatus;
	}
	
	/**
	 * 创建时间
	 * @param createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 创建时间
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 创建人
	 * @param creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * 创建人
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/**
	 * 更新时间
	 * @param updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 更新时间
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 更新人
	 * @param updator
	 */
	public String getUpdator() {
		return updator;
	}
	
	/**
	 * 更新人
	 * @param updator
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	
	/**
	 * 字典状态
	 * @param status
	 */
	public Boolean getStatus() {
		return status;
	}
	
	/**
	 * 字典状态
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTbsName() {
		return tbsName;
	}

	public void setTbsName(String tbsName) {
		this.tbsName = tbsName;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public List<Dict> getChildren() {
		return children;
	}

	public void setChildren(List<Dict> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public List<Dict> getQuasiDrivingType() {
		return quasiDrivingType;
	}

	public void setQuasiDrivingType(List<Dict> quasiDrivingType) {
		this.quasiDrivingType = quasiDrivingType;
	}

	public List<Dict> getCarType() {
		return carType;
	}

	public void setCarType(List<Dict> carType) {
		this.carType = carType;
	}

	public List<Dict> getPlateNumPrefix() {
		return plateNumPrefix;
	}

	public void setPlateNumPrefix(List<Dict> plateNumPrefix) {
		this.plateNumPrefix = plateNumPrefix;
	}
}