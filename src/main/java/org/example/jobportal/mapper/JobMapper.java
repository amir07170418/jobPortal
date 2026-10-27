package org.example.jobportal.mapper;

import org.example.jobportal.dto.JobRequest;
import org.example.jobportal.dto.JobResponse;
import org.example.jobportal.model.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobMapper {
    @Mapping(source = "employer.id",target = "employerId" )
    JobResponse toResponse(Job job);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "jobStatus",ignore = true)
    @Mapping(target = "employer",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    Job toEntity(JobRequest jobRequest);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "jobStatus",ignore = true)
    @Mapping(target = "employer",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    Job updateEntity(JobRequest jobRequest, @MappingTarget Job job);
}
