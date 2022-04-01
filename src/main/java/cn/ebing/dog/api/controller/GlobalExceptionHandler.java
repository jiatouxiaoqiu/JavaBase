package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.domain.response.CommonResponse;
import cn.ebing.dog.api.exception.BaseException;
import cn.ebing.dog.api.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> restClientHandle(Exception e) {
        logger.error("GlobalExceptionHandler Exception -->" + e);
        e.printStackTrace();
        CommonResponse commonResponse = new CommonResponse<>(null);

        if (e instanceof BaseException) {
            commonResponse.setCode(Integer.parseInt(((BaseException) e).getErrorCode()));
            commonResponse.setMessage(((BaseException) e).getErrorMessage());
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        }

        commonResponse.setCode(Integer.parseInt(ErrorCodeEnum.SERVICE_ERROR.getCode()));
        commonResponse.setMessage(e.toString() + ErrorCodeEnum.SERVICE_ERROR.getMessage());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
