package com.lin.springboot1.mapper;

import com.lin.springboot1.pojo.Department;
import com.lin.springboot1.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeMapper {
    private static Map<Integer, Employee> employeeMap=null;
    @Autowired
    private DepartmentMapper departmentMapper;
    static{
        employeeMap=new HashMap<Integer,Employee>();
        employeeMap.put(1001,new Employee(1001,"aa","1111@123.com",1,new Department(101,"教育部")));
        employeeMap.put(1002,new Employee(1002,"bb","111441@123.com",2,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"cc","1231@123.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"dd","1111@123.com",2,new Department(105,"后勤部")));
        employeeMap.put(1005,new Employee(1005,"ee","144111@123.com",1,new Department(104,"运营部")));
    }
    //增加一个员工
    private static Integer id=1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(id++);
        }
        employee.setDepartment(departmentMapper.getDepartmentByid(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }
    //查询全部
    public Collection<Employee> getEmployees(){
        return employeeMap.values();
    }
    //id查询
    public Employee getEmployeeByid(Integer id){
        return employeeMap.get(id);
    }
    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
