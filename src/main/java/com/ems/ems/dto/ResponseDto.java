package com.ems.ems.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Boolean status;
    private String message;
    private Object data;
}
