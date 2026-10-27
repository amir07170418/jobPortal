package org.example.jobportal.dto;

import org.example.jobportal.model.JobStatus;
import org.example.jobportal.model.JobType;

import java.time.LocalDate;

public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private Long salaryMin;
    private Long salaryMax;
    private JobType jobType;
    private JobStatus jobStatus;
    private LocalDate createdAt;
    private LocalDate expiresAt;
    private Long employerId;

    public JobResponse(Long id, String title, String description, String location, Long salaryMin, Long salaryMax
            , JobType jobType, JobStatus jobStatus, LocalDate createdAt, LocalDate expiresAt, Long employerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.employerId = employerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Long salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Long getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Long salaryMax) {
        this.salaryMax = salaryMax;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDate expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    @Override
    public String toString() {
        return "JobResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", jobType=" + jobType +
                ", jobStatus=" + jobStatus +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", employerId=" + employerId +
                '}';
    }
}
