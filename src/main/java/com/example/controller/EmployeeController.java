package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 従業員詳細画面を表示する.
     * 
     * @param id
     * @param model
     * @param form
     * @return
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(form.getIntId());
        model.addAttribute("employee", employee);

        return "employee/detail";
    }

    /**
     * 従業員情報を更新する.
     * 
     * @param form
     * @return
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(form.getIntId());
        employee.setDependentsCount(form.getIntDependentsCount());
        employeeService.update(employee);

        return "redirect:/employee/showList";
    }

}
