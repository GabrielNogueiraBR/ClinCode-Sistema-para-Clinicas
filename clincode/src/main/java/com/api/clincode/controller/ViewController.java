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

    @GetMapping("login")
    public ModelAndView paginaLogin(){
        return new ModelAndView("loginPaciente");
    }
    
    @GetMapping("cadastro/pacientes")
    public ModelAndView cadastroPaciente(){
        return new ModelAndView("cad-pacientes");
    }

    @GetMapping("cadastro/medicos")
    public ModelAndView cadastroMedico(){
        return new ModelAndView("cad-medico");
    }  
    
    @GetMapping("cadastro/atendentes")
    public ModelAndView cadastroAtendente(){
        return new ModelAndView("cad-atendentes");
    }
    
    @GetMapping("admin")
    public ModelAndView adminIndex(){
        return new ModelAndView("admin");
    }
}