package com.yzu.recruit.web.model;

public class Operation {
    private String opinion;
    private int statusID;
    private int jobRequestID;

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getJobRequestID() {
        return jobRequestID;
    }

    public void setJobRequestID(int jobRequestID) {
        this.jobRequestID = jobRequestID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

}
