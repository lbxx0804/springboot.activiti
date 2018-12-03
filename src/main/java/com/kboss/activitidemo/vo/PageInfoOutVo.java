package com.kboss.activitidemo.vo;

import java.util.List;

public class PageInfoOutVo<T> {

    public PageInfoOutVo() {
    }

    public PageInfoOutVo(List<T> result, Integer total) {
        this.result = result;
        this.total = total;
    }

    private List<T> result;

    private Integer total;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
