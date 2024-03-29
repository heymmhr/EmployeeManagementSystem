package com.ems.ems.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Boolean isNepaliBoard;

    //used while saving
    private MultipartFile courseFile;

    //used while sending or listing data to front end
    private String filePath;
}
