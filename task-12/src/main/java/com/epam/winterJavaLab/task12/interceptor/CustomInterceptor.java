package com.epam.winterJavaLab.task12.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


@Component
public class CustomInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LogManager.getLogger(CustomInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("The handler: " + handler.toString() + " received the request");
        logger.info("Request URL: " + (request.getRequestURL()));
        logger.info("Servlet path: " + (request.getServletPath()));
        logger.info("Remote host: " + (request.getRemoteHost()));
        logger.info("Local port: " + (request.getLocalPort()));

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            logger.info("Parameter: " + (parameterName) + " = " + request.getParameter(parameterName));
        }

        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        logger.info("The handler: " + handler.toString() + " processed the request");
        super.postHandle(request, response, handler, modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
