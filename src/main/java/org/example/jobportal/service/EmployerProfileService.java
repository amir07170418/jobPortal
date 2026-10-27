package org.example.jobportal.service;

import jakarta.transaction.Transactional;
import org.example.jobportal.dto.EmployerProfileRequest;
import org.example.jobportal.dto.EmployerProfileResponse;
import org.example.jobportal.exception.JobPortalException;
import org.example.jobportal.mapper.EmployerProfileMapper;
import org.example.jobportal.model.EmployerProfile;
import org.example.jobportal.model.Role;
import org.example.jobportal.repository.EmployerProfileRepository;
import org.example.jobportal.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployerProfileService implements JobPortalService<EmployerProfileRequest, EmployerProfileResponse> {
    private final EmployerProfileRepository employerProfileRepository;
    private final UserRepository userRepository;
    private final EmployerProfileMapper employerProfileMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployerProfileService(EmployerProfileRepository employerProfileRepository
            , UserRepository userRepository, EmployerProfileMapper employerProfileMapper, PasswordEncoder passwordEncoder) {
        this.employerProfileRepository = employerProfileRepository;
        this.userRepository = userRepository;
        this.employerProfileMapper = employerProfileMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public EmployerProfileResponse Save(EmployerProfileRequest employerProfileRequest) {
        if (userRepository.existsByEmail(employerProfileRequest.getEmail())) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "User with this email  already exist");
        } else {
            EmployerProfile employerProfile = employerProfileMapper.toEntity(employerProfileRequest);
            employerProfile.setPassword(passwordEncoder.encode(employerProfile.getPassword()));
            employerProfile.setRole(Role.EMPLOYER);
            employerProfile.setCreatedAt(LocalDateTime.now());
            employerProfileRepository.save(employerProfile);
            return employerProfileMapper.toResponse(employerProfile);
        }
    }

    @Override
    public EmployerProfileResponse findById(Long id) {
        EmployerProfile employerProfile = employerProfileRepository.findById(id).orElseThrow
                (() -> new JobPortalException(HttpStatus.NOT_FOUND, "EmployerProfile not found"));
        return employerProfileMapper.toResponse(employerProfile);
    }

    @Transactional
    @Override
    public EmployerProfileResponse update(Long id, EmployerProfileRequest employerProfileRequest) {
        EmployerProfile employerProfile = employerProfileRepository.findById(id).orElseThrow
                (() -> new JobPortalException(HttpStatus.NOT_FOUND, "EmployerProfile not found"));
        employerProfileMapper.updateEntity(employerProfileRequest, employerProfile);
        employerProfile.setPassword(passwordEncoder.encode(employerProfile.getPassword()));

        return employerProfileMapper.toResponse(employerProfile);
    }

    @Override
    public Page<EmployerProfileResponse> findAll(Pageable pageable) {
        Page<EmployerProfile> employerProfiles = employerProfileRepository.findAll(pageable);
        return employerProfiles.map(employerProfileMapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        EmployerProfile employerProfile = employerProfileRepository.findById(id).orElseThrow
                (() -> new JobPortalException(HttpStatus.NOT_FOUND, "EmployerProfile not found"));
        employerProfileRepository.delete(employerProfile);
    }
}
