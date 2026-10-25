package org.example.jobportal.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class JobApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ApplyStatus status;
    private LocalDateTime applyTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobSeeker_id" )
    private JobSeekerProfile jobSeeker;

    public JobApply(Long id, ApplyStatus status, LocalDateTime applyTime, Job job, JobSeekerProfile jobSeeker) {
        this.id = id;
        this.status = status;
        this.applyTime = applyTime;
        this.job = job;
        this.jobSeeker = jobSeeker;
    }

    public JobApply() {
    }

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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobSeekerProfile getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeekerProfile jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobApply jobApply = (JobApply) o;
        return Objects.equals(id, jobApply.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "JobApply{" +
                "id=" + id +
                ", status=" + status +
                ", applyTime=" + applyTime +
                '}';
    }
}
