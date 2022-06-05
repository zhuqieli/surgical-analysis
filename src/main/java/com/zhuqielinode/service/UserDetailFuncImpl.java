package com.zhuqielinode.service;

import com.zhuqielinode.dao.UserMapper;
import com.zhuqielinode.exception.GlobalException;
import com.zhuqielinode.po.User;
import com.zhuqielinode.util.ValidatorUtil;
import com.zhuqielinode.vo.RespBean;
import com.zhuqielinode.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Component
public class UserDetailFuncImpl implements UserDetailFunc {
    @Autowired
    private UserMapper mapper;
    @Override
    public RespBean insert(User user) {
        if(user==null||user.getEmail()==""||user.getPassword()==""){
            throw new GlobalException(RespBeanEnum.MESSAGE_ERROR);
        }
        User user1 = mapper.selectByPrimaryKey(user.getEmail());
        if(user1!=null)
            throw new GlobalException(RespBeanEnum.SAVE_ERROR);
        String userEmail=user.getEmail();
        if(!ValidatorUtil.isEmail(userEmail)){
            throw new GlobalException(RespBeanEnum.EMAIL_ERROR);
        }
        user.setStatu(0);
        int num=mapper.insert(user);
        return RespBean.success();
    }

    @Override
    public RespBean updateUserPassword(String password) {
        return null;
    }

    @Override
    public RespBean selectUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public User selectUser(String email, String password) {
        return null;
    }


}
