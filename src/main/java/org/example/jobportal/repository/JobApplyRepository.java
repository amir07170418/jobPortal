package org.example.jobportal.repository;

import org.example.jobportal.model.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplyRepository extends JpaRepository<JobApply,Long> {
    @Query("select count(j)>0 from JobApply j where j.job.id=:jobId and j.jobSeeker.id=:jobSeekerId")
    boolean existsByJobIdAndJobSeekerId(Long jobId, Long jobSeekerId);

}
