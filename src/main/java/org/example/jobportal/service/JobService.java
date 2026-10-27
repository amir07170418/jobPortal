package org.example.jobportal.service;

import jakarta.transaction.Transactional;
import org.example.jobportal.dto.JobRequest;
import org.example.jobportal.dto.JobResponse;
import org.example.jobportal.exception.JobPortalException;
import org.example.jobportal.mapper.JobMapper;
import org.example.jobportal.model.EmployerProfile;
import org.example.jobportal.model.Job;
import org.example.jobportal.model.JobStatus;
import org.example.jobportal.repository.EmployerProfileRepository;
import org.example.jobportal.repository.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JobService implements JobPortalService<JobRequest, JobResponse> {
    private final JobRepository jobRepository;
    private final EmployerProfileRepository employerProfileRepository;
    private final JobMapper jobMapper;

    public JobService(JobRepository jobRepository, EmployerProfileRepository employerProfileRepository, JobMapper jobMapper) {
        this.jobRepository = jobRepository;
        this.employerProfileRepository = employerProfileRepository;
        this.jobMapper = jobMapper;
    }

    @Override
    public JobResponse Save(JobRequest jobRequest) {
        if (jobRepository.existsByTitleAndEmployer(jobRequest.getTitle(), jobRequest.getEmployerId())){
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "Job already exists");
        }
        EmployerProfile employerProfile = employerProfileRepository.findById(jobRequest.getEmployerId())
                .orElseThrow(()-> new JobPortalException(HttpStatus.BAD_REQUEST, "Employer not found"));
        Job job = jobMapper.toEntity(jobRequest);
        job.setEmployer(employerProfile);
        job.setCreatedAt(LocalDate.now());
        job.setJobStatus(JobStatus.OPEN);
        jobRepository.save(job);
        return jobMapper.toResponse(job);
    }

    @Override
    public JobResponse findById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(()->
                new JobPortalException(HttpStatus.BAD_REQUEST, "Job not found"));
        return jobMapper.toResponse(job);
    }

    @Transactional
    @Override
    public JobResponse update(Long id, JobRequest jobRequest) {
        Job job = jobRepository.findById(id).orElseThrow(()->
                new JobPortalException(HttpStatus.BAD_REQUEST, "Job not found"));
        jobMapper.updateEntity(jobRequest,job);
        jobRepository.save(job);
        return jobMapper.toResponse(job);
    }

    @Override
    public Page<JobResponse> findAll(Pageable pageable) {
        return jobRepository.findAll(pageable).map(jobMapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(()->
                new JobPortalException(HttpStatus.BAD_REQUEST, "Job not found"));
    }
}
