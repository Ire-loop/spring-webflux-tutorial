package com.example.webfluxtutorial.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private ErrorDetails errorDetails;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    ErrorResponse(String code, String message, List<FieldError> details) {
        this.errorDetails = new ErrorDetails(code, message, details.stream().map(FieldError::getDefaultMessage).toList());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ErrorDetails {
        String code;
        String message;
        List<String> details;
    }
}
