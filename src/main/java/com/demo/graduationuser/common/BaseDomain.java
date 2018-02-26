package com.demo.graduationuser.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author chenjingxiong
 */
public class BaseDomain implements Serializable {

    @JsonIgnore
    @Transient
    private Integer pageSize;

    @JsonIgnore
    @Transient
    private Integer pageNum;

    @JsonIgnore
    @Transient
    private String orderBy;

    @JsonIgnore
    @Transient
    private Set<String> fieldsToUpdate;

    @Transient
    @JsonIgnore
    public static final Integer DEFALUT_PAGE_NUM = 1;
    @JsonIgnore
    @Transient
    public static final Integer DEFALUT_PAGE_SIZE = 100;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select REPLACE(uuid(),'-','')")
    private String id;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.creation_date
     * </pre>
     */
    private Date creationDate;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.created_by
     * </pre>
     */
    private String createdBy;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.last_update_date
     * </pre>
     */
    private Date lastUpdateDate;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.last_updated_by
     * </pre>
     */
    private String lastUpdatedBy;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.last_updated_login
     * </pre>
     */
    private String lastUpdatedLogin;

    /**
     * <pre>
     *
     * 表字段 : ciip_org_wf_approved_his.versions
     * </pre>
     */
    private Integer versions;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedLogin() {
        return lastUpdatedLogin;
    }

    public void setLastUpdatedLogin(String lastUpdatedLogin) {
        this.lastUpdatedLogin = lastUpdatedLogin;
    }

    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Set<String> getFieldsToUpdate() {
        return fieldsToUpdate;
    }

    public void setFieldsToUpdate(Set<String> fieldsToUpdate) {
        this.fieldsToUpdate = fieldsToUpdate;
    }
}
