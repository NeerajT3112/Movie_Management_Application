package com.ey.moviemanagement.config;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@Builder
public class ApiError {
    public HttpStatus status;
    public String exceptionMessage;



}
