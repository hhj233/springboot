package com.lin.springboot1.controller;

import com.lin.springboot1.mapper.DepartmentMapper;
import com.lin.springboot1.mapper.EmployeeMapper;
import com.lin.springboot1.pojo.Department;
import com.lin.springboot1.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeList {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @RequestMapping("/emps")
    public String getList(Model model){
        Collection<Employee> employees= employeeMapper.getEmployees();
        model.addAttribute("emps",employees);
        return "emp/list.html";
    }
    @GetMapping("/emp")
    public String toAdd(Model model){
        //查出所有部门信息
        Collection<Department> departments=departmentMapper.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add.html";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加操作
        System.out.println("debug=>"+employee);
        employeeMapper.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee=employeeMapper.getEmployeeByid(id);
        //查出所有部门信息
        Collection<Department> departments=departmentMapper.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",employee);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeMapper.save(employee);
        return "redirect:/emps";
    }
    //删除
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.delete(id);
        return "redirect:/emps";
    }
    @GetMapping("/signout")
    public String signout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
