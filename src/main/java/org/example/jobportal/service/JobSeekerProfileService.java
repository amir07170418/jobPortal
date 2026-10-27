package org.example.jobportal.service;

import jakarta.transaction.Transactional;
import org.example.jobportal.dto.JobSeekerProfileRequest;
import org.example.jobportal.dto.JobSeekerProfileResponse;
import org.example.jobportal.exception.JobPortalException;
import org.example.jobportal.mapper.JobSeekerProfileMapper;
import org.example.jobportal.model.Job;
import org.example.jobportal.model.JobSeekerProfile;
import org.example.jobportal.model.Role;
import org.example.jobportal.repository.JobSeekerProfileRepository;
import org.example.jobportal.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobSeekerProfileService implements JobPortalService<JobSeekerProfileRequest, JobSeekerProfileResponse> {
    private final UserRepository userRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final JobSeekerProfileMapper jobSeekerProfileMapper;
    private final PasswordEncoder passwordEncoder;

    public JobSeekerProfileService(UserRepository userRepository, JobSeekerProfileRepository jobSeekerProfileRepository, JobSeekerProfileMapper jobSeekerProfileMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.jobSeekerProfileMapper = jobSeekerProfileMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JobSeekerProfileResponse Save(JobSeekerProfileRequest jobSeekerProfileRequest) {
        if (userRepository.existsByEmail(jobSeekerProfileRequest.getEmail())) {
            throw  new JobPortalException(HttpStatus.BAD_REQUEST,"user with this email exist");
        }
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileMapper.toEntity(jobSeekerProfileRequest);
        jobSeekerProfile.setPassword(passwordEncoder.encode(jobSeekerProfile.getPassword()));
        jobSeekerProfile.setRole(Role.JOB_SEEKER);
        jobSeekerProfile.setCreatedAt(LocalDateTime.now());
        jobSeekerProfileRepository.save(jobSeekerProfile);
        return jobSeekerProfileMapper.toResponse(jobSeekerProfile);
    }

    @Override
    public JobSeekerProfileResponse findById(Long id) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(id).orElseThrow(()
                -> new JobPortalException(HttpStatus.NOT_FOUND, "JobSeekerProfile not found"));
        return jobSeekerProfileMapper.toResponse(jobSeekerProfile);
    }
    @Transactional
    @Override
    public JobSeekerProfileResponse update(Long id, JobSeekerProfileRequest jobSeekerProfileRequest) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(id).orElseThrow(()
                -> new JobPortalException(HttpStatus.NOT_FOUND, "JobSeekerProfile not found"));
        jobSeekerProfileMapper.updateEntity(jobSeekerProfileRequest, jobSeekerProfile);
        jobSeekerProfile.setPassword(passwordEncoder.encode(jobSeekerProfile.getPassword()));
        jobSeekerProfileRepository.save(jobSeekerProfile);
        return jobSeekerProfileMapper.toResponse(jobSeekerProfile);
    }

    @Override
    public Page<JobSeekerProfileResponse> findAll(Pageable pageable) {
        return  jobSeekerProfileRepository.findAll(pageable).map(jobSeekerProfileMapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(id).orElseThrow(()
                -> new JobPortalException(HttpStatus.NOT_FOUND, "JobSeekerProfile not found"));
        jobSeekerProfileRepository.delete(jobSeekerProfile);
    }
}
