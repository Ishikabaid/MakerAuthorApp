package com.makercheckerapp.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerController.class);
    @ExceptionHandler(NoHandlerFoundException.class)
    ModelAndView handle404(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error","page not found!");
        modelAndView.setViewName("errorpage");
        return modelAndView;
    }

    @ExceptionHandler(DataAccessException.class)
    ModelAndView handleDataAccessException(HttpServletRequest request, DataAccessException dataAccessException){
        ModelAndView modelAndView = new ModelAndView();
        logger.error(dataAccessException.toString());
        modelAndView.addObject("error",dataAccessException);
        modelAndView.setViewName("errorpage");
        return modelAndView;

    }
}
