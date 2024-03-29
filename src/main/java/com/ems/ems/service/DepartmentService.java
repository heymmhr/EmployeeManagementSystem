package com.ems.ems.service;

import com.ems.ems.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> findAll();

    DepartmentDto findById(Integer id);

    void deleteDepartmentById(Integer id);
}
