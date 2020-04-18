package com.kuang.login.controller;

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
    @GetMapping("/validateHomerId")
    public ResultVO validateHomerId(@NotEmpty(message = "user id不能为空")
                                    @RequestParam(required = true, name = "userId") String userId) {
        UserEntity userEntity = loginService.findByHomerId(userId);

        log.info("查询出的homer数据是 {}", userEntity);

        if (ObjectUtils.isEmpty(userEntity)) {
            throw new BaseException(LoginEnum.VALIDATE_HOMER_ID_FAIL.getCode(), LoginEnum.VALIDATE_HOMER_ID_FAIL.getMsg());
        }

        return ResultVOUtil.success(LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getCode(), LoginEnum.VALIDATE_HOMER_ID_SUCCESS.getMsg(), null);
    }

    @PostMapping(value = "/sendSmsCode")
    public ResultVO sendSms(@Validated @RequestBody SmsRequestDto smsRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("请求参数有错误{}", smsRequestDto);
            throw new BaseException(SmsEnum.SMS_SEND_FAIL.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        SmsResponseDto smsResponseDto = smsService.generateSmsCode(smsRequestDto);

        if (smsRequestDto == null) {
            log.error("生成的短信验证码有误");
            throw new BaseException(SmsEnum.SMS_SEND_FAIL.getCode(), SmsEnum.SMS_SEND_FAIL.getMsg());
        }

        return ResultVOUtil.success(SmsEnum.SMS_SEND_SUCCESS.getCode(), SmsEnum.SMS_SEND_SUCCESS.getMsg(), smsResponseDto);
    }

    @PostMapping("/validateSmsCode")
    public ResultVO validateSms(@RequestBody String smsCode) {
        // TODO: 2020/4/18 进行短信验证调用
        return ResultVOUtil.error(200, null);
    }

    @PostMapping("/login")
    public ResultVO login(@RequestBody String homerId) {
        // TODO: 2020/4/18 通过HomerId和Sms Code进行验证
        return ResultVOUtil.error(200, null);
    }
}
