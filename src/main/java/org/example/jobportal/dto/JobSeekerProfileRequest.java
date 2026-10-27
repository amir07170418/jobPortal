package org.example.jobportal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JobSeekerProfileRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    @NotBlank
    private String resumeUrl;
    @NotBlank
    private String skills;
    @NotNull
    private Integer experienceYears;
    @NotBlank
    private String bio;

    public JobSeekerProfileRequest(String firstName, String lastName, String email, String password,
                                   String resumeUrl, String skills, Integer experienceYears, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.resumeUrl = resumeUrl;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.bio = bio;
    }

    public JobSeekerProfileRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "JobSeekerProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", resumeUrl='" + resumeUrl + '\'' +
                ", skills='" + skills + '\'' +
                ", experienceYears=" + experienceYears +
                ", bio='" + bio + '\'' +
                '}';
    }
}
