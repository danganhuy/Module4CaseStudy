package huy.module4casestudy.service.salary;

import huy.module4casestudy.model.Salary;
import huy.module4casestudy.service.IGenericService;

import java.util.List;

public interface ISalaryService extends IGenericService<Salary> {
    List< Salary > getSalariesById(Long id);
}
