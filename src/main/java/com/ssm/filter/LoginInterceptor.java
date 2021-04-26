package com.ssm.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.jsonwebtoken.Claims;

/**
 * 登录拦截器
 *
 * @author Mukden
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            this.setErrorResponse(response, "未携带token");
            return false;
        }
        try {
            Claims claims = JWTUtils.parseJWT(authorization);
            System.out.println("解析jwt：" + claims.getSubject());
            request.setAttribute("user", claims);

            //如果JWT存储时间小于当前时间 表示登录过期
            if (claims.getExpiration().getTime() < new Date().getTime()) {
                this.setErrorResponse(response, "登录过期");
                return false;
            }
        } catch (Exception e) {
            this.setErrorResponse(response, e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

    protected void setErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
        response.getWriter().flush();
        response.getWriter().close();
    }

}
