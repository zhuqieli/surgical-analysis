package com.zhuqielinode.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private static final Pattern mobile_pattern =Pattern.compile("^[A-Za-z0-9u4e00-u9fa5]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$");

    public static boolean isEmail(String email){
        if(StringUtils.isEmpty(email)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(email);
        return matcher.matches();
    }
}
