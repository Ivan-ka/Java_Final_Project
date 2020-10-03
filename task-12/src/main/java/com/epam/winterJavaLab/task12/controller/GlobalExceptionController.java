package com.epam.winterJavaLab.task12.controller;

import com.epam.winterJavaLab.task12.constants.ConstantsView;
import com.epam.winterJavaLab.task12.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleCustomException(CustomException ex) {

        ModelAndView model = new ModelAndView(ConstantsView.ERROR_TEMPLATE);
        model.addObject("errCode", ex.getErrCode());
        model.addObject("errMsg", ex.getErrMsg());

        return model;
    }

}
