package com.zhuqielinode.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    //用户模块
    MESSAGE_ERROR(500210,"注册信息不完整"),//save,update
    LOGIN_ERROR(500211,"登录信息不匹配"),//登录
    EMAIL_ERROR(500212,"邮箱格式不正确"),//isEmail
    BIND_ERROR(500213,"参数校验异常"),
    SAVE_ERROR(500214,"用户email已存在"),
    ILLEGAL_ERROR(500215,"非法请求，检查您的操作"),
    NOT_LOGIN(500100,"请先登录");
    private final Integer code;
    private final String message;

}