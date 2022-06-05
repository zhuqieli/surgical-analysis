package com.zhuqielinode.service;

import com.zhuqielinode.po.User;
import com.zhuqielinode.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserDetailFunc {
    RespBean insert(User user);
    RespBean updateUserPassword(String password);
    RespBean selectUser(String email,String password , HttpServletRequest request, HttpServletResponse response);
    User selectUser(String email,String password);
}
