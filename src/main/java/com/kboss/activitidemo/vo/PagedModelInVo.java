package com.kboss.activitidemo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PagedModelInVo {

    public PagedModelInVo() {
    }

    public PagedModelInVo(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    private Integer pageNumber;

    private Integer pageSize;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonIgnore
    public Integer getStartPage() {
        return (this.pageNumber - 1) * this.pageSize;
    }
}
