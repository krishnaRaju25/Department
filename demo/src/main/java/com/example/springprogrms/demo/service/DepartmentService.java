package com.example.springprogrms.demo.service;

import com.example.springprogrms.demo.Exception.DepartmentIdCheckException;
import com.example.springprogrms.demo.Repository.DepartmentRepository;
import com.example.springprogrms.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department addDep(Department dep)
    {
        if(departmentRepository.existsById(dep.getDepartment_id()))
        {
            departmentRepository.save(dep);
        }else if(dep.getDepartment_id() > 0 )
        {
            departmentRepository.save(dep);
        } else {
            throw new DepartmentIdCheckException();
        }
        return dep;
    }
    public List<Department> getAlldep()
    {

        return departmentRepository.findAll();
    }

    public Department getByid(int id)
    {
        return departmentRepository.findById(id).get();

    }

    public Long getCount()
    {
     Long count = departmentRepository.count();
       return count;
          }
  public List<Department> getAllCity(String city) {
    return departmentRepository.findByCity(city);

  }
}
