package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class OpenAiInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("pre handler");
        //true = controller 전달. false 전달하지 않는다.
        var handlerMethod = (HandlerMethod) handler; //형변환

        //method레벨에서 어노테이션을 가지고 있는지
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
        if(methodLevel != null){
            log.info("method level");
            return true;
        }

        //class level에서 openapi 어노테이션 가지고 있는지
        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if(classLevel != null){
            log.info("class level");
            return true;
        }

        log.info(" 해당 주소는 open api가 아님 {}",request.getRequestURI());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("post Handler ");
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("After completion");
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
