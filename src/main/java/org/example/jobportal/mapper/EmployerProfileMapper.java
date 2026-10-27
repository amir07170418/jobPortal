package org.example.jobportal.mapper;

import org.example.jobportal.dto.EmployerProfileRequest;
import org.example.jobportal.dto.EmployerProfileResponse;
import org.example.jobportal.model.EmployerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployerProfileMapper {

    EmployerProfileResponse toResponse(EmployerProfile employerProfile);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    EmployerProfile toEntity(EmployerProfileRequest employerProfileRequest);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(target = "role",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    EmployerProfile updateEntity(EmployerProfileRequest employerProfileRequest, @MappingTarget EmployerProfile employerProfile);
}
