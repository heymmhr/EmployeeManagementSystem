package com.ems.ems.service.impl;

import com.ems.ems.dto.DepartmentDto;
import com.ems.ems.entities.Department;
import com.ems.ems.repo.DepartmentRepository;
import com.ems.ems.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department entity = new Department();
        entity.setId(departmentDto.getId());
        entity.setName(departmentDto.getName());
        entity.setShortCode(departmentDto.getShortCode());
        entity.setStatus(departmentDto.getStatus());

        entity = departmentRepository.save(entity);
        return DepartmentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .shortCode(entity.getShortCode())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public List<DepartmentDto> findAll() {

        List <Department> departments = departmentRepository.findAll();

        return departments.stream().map( d->
                DepartmentDto.builder()
                        .id(d.getId())
                        .name(d.getName())
                        .shortCode(d.getShortCode())
                        .status(d.getStatus())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Integer id) {
        Department d;
        Optional <Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()){
            d = optionalDepartment.get();

            return DepartmentDto.builder()
                    .id(d.getId())
                    .name(d.getName())
                    .shortCode(d.getShortCode())
                    .status(d.getStatus())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer id) {

        departmentRepository.deleteById(id);
    }
}
