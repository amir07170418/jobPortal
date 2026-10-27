package org.example.jobportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class EmployerProfile extends User{
    private String companyName;
    private String address;
    private String companyDescription;
    private String website;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employer")
    private Set<Job> jobs;

    public EmployerProfile(Long id, String firstName, String lastName, String email, String password, Role role,
                           LocalDateTime createdAt, String companyName, String address, String companyDescription, String website) {
        super(id, firstName, lastName, email, password, role, createdAt);
        this.companyName = companyName;
        this.address = address;
        this.companyDescription = companyDescription;
        this.website = website;
    }
    public EmployerProfile() {super();}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "EmployerProfile{" +
                super.toString() +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
