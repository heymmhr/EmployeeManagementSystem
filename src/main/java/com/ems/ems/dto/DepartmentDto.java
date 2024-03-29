package com.ems.ems.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Integer id;
    private String name;
    private String shortCode;
    private Boolean status;
}
