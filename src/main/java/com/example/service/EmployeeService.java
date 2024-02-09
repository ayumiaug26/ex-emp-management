package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を全件取得する.
     * 
     * @return 取得した従業員情報のリスト
     */
    public List<Employee> showList() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    /**
     * 従業員情報をID検索して取得する.
     * 
     * @param id 検索する従業員のID
     * @return Employee
     */
    public Employee showDetail(Integer id) {
        Employee employee = employeeRepository.load(id);
        return employee;
    }

    /**
     * 従業員情報を更新する
     * 
     * @param employee
     */
    public void update(Employee employee){
        employeeRepository.update(employee);
    }

}
