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

}
