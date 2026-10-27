package org.example.jobportal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobPortalService<R,P> {
    public P Save(R r);
    public P findById(Long id);
    public P update(Long id,R r);
    public Page<P>  findAll(Pageable pageable);
    public void delete(Long id);
}
