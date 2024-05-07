package com.telusko.SpringTry.companies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyModel,Long> {
}
