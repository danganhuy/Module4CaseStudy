package huy.module4casestudy.service.salary;

import huy.module4casestudy.model.Salary;
import huy.module4casestudy.repository.ISalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService implements ISalaryService {
    @Autowired
    private ISalaryRepository salaryRepository;

    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public Optional<Salary> findById(Long id) {
        return salaryRepository.findById(id);
    }

    @Override
    public void save(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public void delete(Salary salary) {
        salaryRepository.delete(salary);
    }
}
