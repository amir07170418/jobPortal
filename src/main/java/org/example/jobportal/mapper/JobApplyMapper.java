package org.example.jobportal.mapper;

import org.example.jobportal.dto.JobApplyRequest;
import org.example.jobportal.dto.JobApplyResponse;
import org.example.jobportal.model.JobApply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobApplyMapper {
    @Mapping(source = "job.id",target = "jobId")
    @Mapping(source = "jobSeeker.id",target = "jobSeekerId")
    JobApplyResponse toResponse(JobApply jobApply);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "applyTime", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "jobSeeker", ignore = true)
    JobApply toEntity(JobApplyRequest jobApplyRequest);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "applyTime", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "jobSeeker", ignore = true)
    JobApply updateEntity(JobApplyRequest jobApplyRequest, @MappingTarget JobApply jobApply);
}
