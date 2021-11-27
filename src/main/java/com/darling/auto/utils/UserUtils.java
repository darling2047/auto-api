package com.darling.auto.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author dll
 * @create 2020/5/30 10:06
 * @describe
 */
public class UserUtils {

    private static final ThreadLocal<HttpServletRequest> request = new ThreadLocal();
    private static final ThreadLocal<HttpServletResponse> response = new ThreadLocal();

    public UserUtils() {
    }

    public static void setRequest(HttpServletRequest req) {
        System.out.println(Thread.currentThread());
        request.set(req);
    }

    public static final HttpServletRequest getRequest() {
        System.out.println(Thread.currentThread());
        HttpServletRequest httpServletRequest = request.get();
        return (HttpServletRequest)request.get();
    }

    public static void removeRequest() {
        request.remove();
    }

    public static void setResponse(HttpServletResponse rep) {
        response.set(rep);
    }

    public static final HttpServletResponse getResponse() {
        return (HttpServletResponse)response.get();
    }

    public static void removeResponse() {
        response.remove();
    }

    public static final HttpSession getSession() {
        return ((HttpServletRequest)request.get()).getSession();
    }

    public static String getVal(String key) {
        return getRequest().getParameter(key);
    }

    public static boolean isAjax(HttpServletRequest request) {
        return request.getHeader("accept") != null && request.getHeader("accept").indexOf("application/json") > -1 || request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1;
    }
}
