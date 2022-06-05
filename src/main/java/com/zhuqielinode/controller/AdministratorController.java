package com.zhuqielinode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SurgicalAnalysis/Administraor")
public class AdministratorController {

    @GetMapping("/selectByUid")
    public void selectUserbyId(){
        return ;
    }
    @PostMapping("/updateUserState")
    public void updateUser(){
        return ;
    }
    @GetMapping("/viewArithmetic")
    public void viewArithmetic(){

    }
    @PostMapping("/setArithmetic")
    public void setArithmetic(){
        return;
    }
    @PostMapping("/updateArithmetic")
    public void updateArithmetic(){
        return;
    }
    @PostMapping("/deleteArithmetic")
    public void deleteArithmetic(){
        return;
    }
    @PostMapping("/updateCase")
    public void updateCase(){
        return ;
    }
//    @PostMapping("")
//    public void identityUser(){
//        return;
//    }
//    @GetMapping("")
//    public void getIdentifiedUser(){
//        return ;
//    }

}
