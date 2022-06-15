package com.practicasjunio2022.fruteria.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	private static final String PATH = "/error";
    @RequestMapping(value = PATH)
    public ModelAndView saveLeadQuery() {           
        return new ModelAndView("forward:/");
    }
    public String getErrorPath() {
        return PATH;
    }
}
