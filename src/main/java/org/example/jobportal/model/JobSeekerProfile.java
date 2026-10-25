package org.example.jobportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class JobSeekerProfile extends User{
    private String resumeUrl;
    private String skills;
    private Integer experienceYears;
    private String bio;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "jobSeeker")
    private Set<JobApply> jobApplies;

    public JobSeekerProfile(Long id, String firstName, String lastName, String email, String password, Role role
            , LocalDateTime createdAt, String resumeUrl, String skills, Integer experienceYears, String bio) {
        super(id, firstName, lastName, email, password, role, createdAt);
        this.resumeUrl = resumeUrl;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.bio = bio;
    }

    public JobSeekerProfile() {super();}

    public Set<JobApply> getJobApplies() {
        return jobApplies;
    }

    public void setJobApplies(Set<JobApply> jobApplies) {
        this.jobApplies = jobApplies;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                super.toString() +
                "resumeUrl='" + resumeUrl + '\'' +
                ", skills='" + skills + '\'' +
                ", experienceYears=" + experienceYears +
                ", bio='" + bio + '\'' +
                '}';
    }
}
