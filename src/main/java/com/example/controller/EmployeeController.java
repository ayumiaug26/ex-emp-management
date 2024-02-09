package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UpdateEmployeeForm;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping({ "/employee", "/employee/" })
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧を出力する.
     * 
     * @param model
     * @return 従業員リスト
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }

    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Integer IntId = Integer.parseInt(id);
        Employee employee = employeeService.showDetail(IntId);
        model.addAttribute("employee", employee);

        return "employee/detail";
    }

}
