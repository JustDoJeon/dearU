package com.dearU.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ResponseStatus;


//405 에러 처리를 위한 메소드 생성
@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class NotSupportedException extends HttpRequestMethodNotSupportedException {
    public NotSupportedException(String message) {
        super(message);
    }
}
