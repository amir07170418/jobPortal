package org.example.jobportal.mapper;

import org.example.jobportal.dto.JobSeekerProfileRequest;
import org.example.jobportal.dto.JobSeekerProfileResponse;
import org.example.jobportal.model.JobSeekerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobSeekerProfileMapper {
    JobSeekerProfileResponse toResponse(JobSeekerProfile jobSeekerProfile);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    JobSeekerProfile toEntity(JobSeekerProfileRequest jobSeekerProfileRequest);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    JobSeekerProfile updateEntity(JobSeekerProfileRequest jobSeekerProfileRequest, @MappingTarget JobSeekerProfile jobSeekerProfile);
}
