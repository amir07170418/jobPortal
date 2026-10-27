package org.example.jobportal.dto;

import jakarta.validation.constraints.NotNull;

public class JobApplyRequest {
    @NotNull
    private Long jobId;
    @NotNull
    private Long jobSeekerId;

    public JobApplyRequest(Long jobId, Long jobSeekerId) {
        this.jobId = jobId;
        this.jobSeekerId = jobSeekerId;
    }
    public JobApplyRequest() {}

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    @Override
    public String toString() {
        return "JobApplyRequest{" +
                "jobId=" + jobId +
                ", jobSeekerId=" + jobSeekerId +
                '}';
    }
}
