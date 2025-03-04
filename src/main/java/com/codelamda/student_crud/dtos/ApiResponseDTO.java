package com.codelamda.student_crud.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponseDTO {

    private Integer statusCode;
    private String status;
    private boolean success;
    private String message;
    private Object data;

    public static ApiResponseDTO success(Object data) {
        var response = success();
        response.setData(data);
        return response;
    }

    public static ApiResponseDTO success() {
        return ApiResponseDTO.builder().success(true).statusCode(HttpStatus.OK.value()).build();
    }

    public static ApiResponseDTO failed500() {
        return ApiResponseDTO.builder().success(false).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
    }
}