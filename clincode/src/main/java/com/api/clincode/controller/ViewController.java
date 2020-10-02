package com.api.clincode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {
    

    @GetMapping("index")
    public ModelAndView paginaInicio(){
        return new ModelAndView("index");
    }

    @GetMapping("loginUsuario")
    public ModelAndView paginaLogin(){
        return new ModelAndView("loginPaciente");
    }
    
    


}
