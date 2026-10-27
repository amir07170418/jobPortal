package org.example.jobportal.repository;

import org.example.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select count(j)>0 from Job j where j.title=:title and j.employer.id=:id")
    boolean existsByTitleAndEmployer(String title, Long id);
}
