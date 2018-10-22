package com.study.px.spring.springtest.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-26 12:07
 **/
public class PageUtilsEasyUI<T> implements Serializable {
    private int total = 1;
    private int records = 0;
    private List<T> rows;
    private T userdata;

    public PageUtilsEasyUI(int total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageUtilsEasyUI(int total, int records, List rows) {
        this.total = total;
        this.records = records;
        this.rows = rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return this.records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public T getUserdata() {
        return this.userdata;
    }

    public void setUserdata(T userdata) {
        this.userdata = userdata;
    }
}
