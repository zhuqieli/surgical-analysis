package com.zhuqielinode.controller;

import com.zhuqielinode.po.User;
import com.zhuqielinode.service.UserDetailFunc;
import com.zhuqielinode.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserDetailFunc userDetailFunc;
    @PostMapping("/user/save")
    public @ResponseBody RespBean saveUserDetial(@Valid User user){
        RespBean rs=userDetailFunc.insert(user);
        return rs ;
    }

//    @GetMapping("")
//    public void loginUser(){
//        return;
//    }
//
//    @PostMapping("")
//    public void updateUserDetial(){
//        return ;
//    }
//    @GetMapping("")
//    public void getCase(){
//        return ;
//    }
//
//
//
//
//
//    @GetMapping("")
//    public void getMyCaseList(){
//
//    }
//    @PostMapping("")
//    public void updateMyCase(){
//
//    }
//    @PostMapping("")
//    public void deleteMyCase(){
//
//    }
}
