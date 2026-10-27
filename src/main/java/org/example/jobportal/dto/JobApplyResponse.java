package org.example.jobportal.dto;

import org.example.jobportal.model.ApplyStatus;
import java.time.LocalDateTime;

public class JobApplyResponse {
    private Long id;
    private ApplyStatus status;
    private LocalDateTime applyTime;
    private Long jobId;
    private Long jobSeekerId;

    public JobApplyResponse(Long id, ApplyStatus status, LocalDateTime applyTime, Long jobId, Long jobSeekerId) {
        this.id = id;
        this.status = status;
        this.applyTime = applyTime;
        this.jobId = jobId;
        this.jobSeekerId = jobSeekerId;
    }
    public JobApplyResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplyStatus getStatus() {
        return status;
    }

    public void setStatus(ApplyStatus status) {
        this.status = status;
    }

    public LocalDateTime getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(LocalDateTime applyTime) {
        this.applyTime = applyTime;
    }

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
        return "JobApplyResponse{" +
                "id=" + id +
                ", status=" + status +
                ", applyTime=" + applyTime +
                ", jobId=" + jobId +
                ", jobSeekerId=" + jobSeekerId +
                '}';
    }
}
