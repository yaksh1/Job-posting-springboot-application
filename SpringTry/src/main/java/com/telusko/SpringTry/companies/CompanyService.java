package com.telusko.SpringTry.companies;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepo companyRepo;

    public List<CompanyModel> getAllCompanies() {
        return companyRepo.findAll();
    }

    public void createCompany(CompanyModel company) {
        companyRepo.save(company);
    }

    public CompanyModel getCompanyById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        if(companyRepo.existsById(id)){

            companyRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    public boolean updateById(Long id, CompanyModel updatedCompany) {
        Optional<CompanyModel> compOptional = companyRepo.findById(id);
        if(compOptional.isPresent()){
            CompanyModel comp = compOptional.get();
            comp.setCompanyName(updatedCompany.getCompanyName());
            comp.setIndustry(updatedCompany.getIndustry());
            comp.setAvgSalary(updatedCompany.getAvgSalary());
            companyRepo.save(comp);
            return true;
        }
        return false;
    }
}
