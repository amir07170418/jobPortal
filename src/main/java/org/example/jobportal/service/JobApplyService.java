package org.example.jobportal.service;

import jakarta.transaction.Transactional;
import org.example.jobportal.dto.JobApplyRequest;
import org.example.jobportal.dto.JobApplyResponse;
import org.example.jobportal.exception.JobPortalException;
import org.example.jobportal.mapper.JobApplyMapper;
import org.example.jobportal.model.ApplyStatus;
import org.example.jobportal.model.Job;
import org.example.jobportal.model.JobApply;
import org.example.jobportal.model.JobSeekerProfile;
import org.example.jobportal.repository.JobApplyRepository;
import org.example.jobportal.repository.JobRepository;
import org.example.jobportal.repository.JobSeekerProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobApplyService implements JobPortalService<JobApplyRequest, JobApplyResponse> {
    private final JobApplyRepository jobApplyRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final JobRepository jobRepository;
    private final JobApplyMapper jobApplyMapper;

    public JobApplyService(JobApplyRepository jobApplyRepository, JobSeekerProfileRepository jobSeekerProfileRepository
            , JobRepository jobRepository, JobApplyMapper jobApplyMapper) {
        this.jobApplyRepository = jobApplyRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.jobRepository = jobRepository;
        this.jobApplyMapper = jobApplyMapper;
    }

    @Transactional
    @Override
    public JobApplyResponse Save(JobApplyRequest jobApplyRequest) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(jobApplyRequest.getJobSeekerId())
                .orElseThrow(() -> new JobPortalException(HttpStatus.NOT_FOUND, "jobSeeker not found"));
        Job job = jobRepository.findById(jobApplyRequest.getJobId())
                .orElseThrow(() -> new JobPortalException(HttpStatus.NOT_FOUND, "job not found"));
        if (jobApplyRepository.existsByJobIdAndJobSeekerId(jobSeekerProfile.getId(), job.getId())) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "jobApply already exists");
        }
        JobApply jobApply = new JobApply();
        jobApply.setJob(job);
        jobApply.setJobSeeker(jobSeekerProfile);
        jobApply.setApplyTime(LocalDateTime.now());
        jobApply.setStatus(ApplyStatus.PENDING);
        jobApplyRepository.save(jobApply);
        return jobApplyMapper.toResponse(jobApply);
    }

    @Override
    public JobApplyResponse findById(Long id) {
        JobApply jobApply=jobApplyRepository.findById(id)
                .orElseThrow(() -> new JobPortalException(HttpStatus.NOT_FOUND, "jobApply not found"));
        return jobApplyMapper.toResponse(jobApply);
    }

    @Override
    public JobApplyResponse update(Long id, JobApplyRequest jobApplyRequest) {
        return null;
    }

    @Override
    public Page<JobApplyResponse> findAll(Pageable pageable) {
        Page<JobApply> jobApplyPage = jobApplyRepository.findAll(pageable);
        return jobApplyPage.map(jobApplyMapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        JobApply jobApply=jobApplyRepository.findById(id)
                .orElseThrow(() -> new JobPortalException(HttpStatus.NOT_FOUND, "jobApply not found"));
        jobApplyRepository.delete(jobApply);
    }
}
