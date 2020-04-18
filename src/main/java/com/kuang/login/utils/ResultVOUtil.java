package com.kuang.login.utils;

import com.kuang.login.vo.ResultVO;

public class ResultVOUtil {

    public static <T> ResultVO success(int code, String msg, T data) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVO error(int code, String msg) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return resultVo;
    }
}
