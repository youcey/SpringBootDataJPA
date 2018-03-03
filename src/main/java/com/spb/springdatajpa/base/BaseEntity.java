package com.spb.springdatajpa.base;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    // * 分页页码,默认页码为1
    protected int page = 1;
    // * 分页每页数量,默认20条
//    protected int size = 20;
    protected int size = 2;
    // * 排序列名称,默认为id
    protected String sidx = "id";
     //* 排序正序
    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
