package com.lin.springboot1.mapper;

import com.lin.springboot1.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentMapper {
    private static Map<Integer, Department> departments=null;
    static{
        departments=new HashMap<Integer,Department>();
        departments.put(101,new Department(101,"教育部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartmentByid(Integer id){
        return departments.get(id);
    }
}
