package com.zhuqielinode.config;


import com.zhuqielinode.exception.GlobalException;
import com.zhuqielinode.po.User;
import com.zhuqielinode.service.UserDetailFunc;
import com.zhuqielinode.util.CookieUtil;
import com.zhuqielinode.vo.LoginVo;
import com.zhuqielinode.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserArgumentResolve implements HandlerMethodArgumentResolver {
    @Autowired
    private UserDetailFunc userDetailFunc;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        return parameterType== LoginVo.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        String email = CookieUtil.getCookieValue(request, "email");
        String password = CookieUtil.getCookieValue(request, "password");
        if(StringUtils.isEmpty(email)||StringUtils.isEmpty(password)){
            throw new GlobalException(RespBeanEnum.NOT_LOGIN);
        }
        User user = userDetailFunc.selectUser(email,password);
        if(user==null){
            throw new GlobalException(RespBeanEnum.NOT_LOGIN);
        }
        LoginVo loginVo = new LoginVo();
        loginVo.setEmail(email);
        loginVo.setPassword(password);
        return loginVo;
    }
}
