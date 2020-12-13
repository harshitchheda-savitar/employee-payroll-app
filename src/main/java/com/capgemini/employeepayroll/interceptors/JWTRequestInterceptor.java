package com.capgemini.employeepayroll.interceptors;

import com.capgemini.employeepayroll.utils.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWTRequestInterceptor class for handling jwttoken request before handing it to controller
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Component
public class JWTRequestInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenHelper tokenHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jwtToken = request.getHeader("authorization");
        tokenHelper.validateToken(jwtToken);
        return true;
    }
}
