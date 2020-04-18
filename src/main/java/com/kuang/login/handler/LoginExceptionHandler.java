package com.kuang.login.handler;

import com.kuang.login.exceptions.BaseException;
import com.kuang.login.utils.ResultVOUtil;
import com.kuang.login.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;


@ControllerAdvice
@Slf4j
public class LoginExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResultVO handleConstraintViolationException(BaseException exception) {
        log.error("code是{}, 消息是{}", exception.getCode(), exception.getMessage());
        return ResultVOUtil.error(exception.getCode(), exception.getMessage());
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResultVO handle(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;

            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                //打印验证不通过的信息
                log.error("验证不通过的信息是 {}", item.getMessage());
            }
        }
        return ResultVOUtil.error(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
