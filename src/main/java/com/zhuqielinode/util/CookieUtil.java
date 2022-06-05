package com.zhuqielinode.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @version 2013 -01 -15
 */
public class CookieUtil {
    /**
     * 设置cookie有效期，根据需要自定义[本系统设置为30天]
     */
    private final static int COOKIE_MAX_AGE = 1000 * 60 * 60 * 24 * 30;

    /**
     * @param response
     * @param cookie
     * @desc 删除指定Cookie
     */
    public static void removeCookie(HttpServletResponse response,
                                    Cookie cookie) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * @param response
     * @param cookie
     * @param domain
     * @desc 删除指定Cookie
     */
    public static void removeCookie(HttpServletResponse response, Cookie cookie,
                                    String domain) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setDomain(domain);
            response.addCookie(cookie);
        }
    }

    /**
     * @param request
     * @param name
     * @return
     * @desc 根据Cookie名称得到Cookie的值，没有返回Null
     */
    public static String getCookieValue(HttpServletRequest request,
                                        String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * @param request
     * @param name
     * @desc 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0)
            return null;
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (!cookies[i].getName().equals(name))
                continue;
            cookie = cookies[i];
            if (request.getServerName().equals(cookie.getDomain()))
                break;
        }

        return cookie;
    }

    /**
     * @param response
     * @param name
     * @param value
     * @desc 添加一条新的Cookie信息，默认有效时间为一个月
     */
    public static void setCookie(HttpServletRequest request,HttpServletResponse response, String name,
                                 String value) {
        setCookie(request,response, name, value, COOKIE_MAX_AGE);
    }

    /**
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @desc 添加一条新的Cookie信息，可以设置其最长有效时间(单位：秒)
     */
    public static void setCookie(HttpServletRequest request,HttpServletResponse response, String name,
                                 String value, int maxAge) {
        if (value == null)
            value = "";
        Cookie cookie = new Cookie(name, value);
        if (maxAge != 0) {
            cookie.setMaxAge(maxAge);
        } else {
            cookie.setMaxAge(COOKIE_MAX_AGE);
        }
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}