package com.telusko.SpringTry.companies;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyModel> getAllCompanies(){
        return service.getAllCompanies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCompany(@RequestBody CompanyModel company){
        service.createCompany(company);
        return "Company Created successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> getCompanyById(@PathVariable Long id){
        CompanyModel company = service.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean isDeleted = service.deleteById(id);
        if(isDeleted){
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not found",HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody CompanyModel updatedCompany){
        boolean isUpdated = service.updateById(id,updatedCompany);
        if(isUpdated){
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
