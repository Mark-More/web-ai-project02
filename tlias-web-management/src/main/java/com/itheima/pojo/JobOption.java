package com.itheima.pojo;


import java.util.List;

public class JobOption {
    private List jobList;//职位列表
    private List dataList;//数据列表

    public List getJobList() {
        return jobList;
    }

    public void setJobList(List jobList) {
        this.jobList = jobList;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
    public JobOption() {
    }
    public JobOption(List jobList, List dataList) {
        this.jobList = jobList;
        this.dataList = dataList;
    }
}
