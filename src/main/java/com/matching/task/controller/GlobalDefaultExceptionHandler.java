package com.matching.task.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
  public final ModelAndView somethingWentWrong(Exception e){
    ModelMap errorModel = new ModelMap();
    errorModel.addAttribute("error", e.getMessage());
    return new ModelAndView("error",errorModel);
  }


}
