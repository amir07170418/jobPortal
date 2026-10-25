package org.example.jobportal.repository;

import org.example.jobportal.model.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplyRepository extends JpaRepository<JobApply,Long> {
}
