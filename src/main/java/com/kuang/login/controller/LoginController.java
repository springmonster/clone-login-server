package com.kuang.login.controller;

import com.kuang.login.dto.LoginRequestDto;
import com.kuang.login.dto.LoginResponseDto;
import com.kuang.login.dto.SmsRequestDto;
import com.kuang.login.dto.SmsResponseDto;
import com.kuang.login.entity.UserEntity;
import com.kuang.login.enums.LoginEnum;
import com.kuang.login.enums.SmsEnum;
import com.kuang.login.exceptions.BaseException;
import com.kuang.login.service.LoginService;
import com.kuang.login.service.SmsService;
import com.kuang.login.utils.ResultVOUtil;
import com.kuang.login.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@RestController
@RequestMapping("/login")
@Validated
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SmsService smsService;

    @Validated
    @GetMapping("/user/{userId}")
    public ResultVO validateHomerId(@NotEmpty(message = "user id不能为空")
                                    @PathVariable(required = true, name = "userId") String userId) {
        UserEntity userEntity = loginService.findByUserId(userId);

        log.info("查询出的homer数据是 {}", userEntity);

        if (ObjectUtils.isEmpty(userEntity)) {
            throw new BaseException(LoginEnum.VALIDATE_HOMER_ID_FAIL.getCode(), LoginEnum.VALIDATE_HOMER_ID_FAIL.getMsg());
        }

        return ResultVOUtil.success(LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getCode(), LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getMsg(), null);
    }

    @PostMapping(value = "/sms")
    public ResultVO sendSms(@Validated @RequestBody SmsRequestDto smsRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("请求参数有错误{}", smsRequestDto);
            throw new BaseException(SmsEnum.SMS_SEND_FAIL.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        SmsResponseDto smsResponseDto = smsService.generateSmsCode();

        if (smsRequestDto == null) {
            log.error("生成的短信验证码有误");
            throw new BaseException(SmsEnum.SMS_SEND_FAIL.getCode(), SmsEnum.SMS_SEND_FAIL.getMsg());
        }

        smsService.saveSmsCode(smsResponseDto.getSmsCode());

        return ResultVOUtil.success(SmsEnum.SMS_SEND_SUCCESS.getCode(), SmsEnum.SMS_SEND_SUCCESS.getMsg(), smsResponseDto);
    }

    @PostMapping("/session")
    public ResultVO validateSms(@Valid @RequestBody LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("请求参数有错误{}", loginRequestDto);
            throw new BaseException(LoginEnum.VALIDATE_HOMER_ID_FAIL.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        if (!smsService.validateSmsCode(loginRequestDto.getSmsCode())) {
            return ResultVOUtil.error(LoginEnum.VALIDATE_HOMER_ID_FAIL.getCode(), LoginEnum.VALIDATE_HOMER_ID_FAIL.getMsg());
        }

        String token = loginService.generateUserToken();

        return ResultVOUtil.success(LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getCode(),
                LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getMsg(),
                new LoginResponseDto(token));
    }
}
