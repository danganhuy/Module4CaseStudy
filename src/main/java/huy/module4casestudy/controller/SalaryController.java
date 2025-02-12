package huy.module4casestudy.controller;

import huy.module4casestudy.model.Salary;
import huy.module4casestudy.service.salary.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/salary")
@CrossOrigin("*")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;

    @GetMapping
    public ResponseEntity<?> getSalary() {
        List<Salary> salaries = salaryService.findAll();
        return ResponseEntity.ok(salaries);
    }
}
