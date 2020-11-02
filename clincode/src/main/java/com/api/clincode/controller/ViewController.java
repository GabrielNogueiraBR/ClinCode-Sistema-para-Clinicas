package com.api.clincode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {
    
    @GetMapping("index")
    public ModelAndView paginaInicio() {
        return new ModelAndView("index");
    }

    @GetMapping("login")
    public ModelAndView paginaLogin() {
        return new ModelAndView("loginPaciente");
    }
    
    @GetMapping("cadastro/pacientes")
    public ModelAndView cadastroPaciente() {
        return new ModelAndView("cad-pacientes");
    }

    @GetMapping("cadastro/medicos")
    public ModelAndView cadastroMedico() {
        return new ModelAndView("cad-medico");
    }  
    
    @GetMapping("cadastro/atendentes")
    public ModelAndView cadastroAtendente() {
        return new ModelAndView("cad-atendentes");
    }
    
    @GetMapping("cadastro/agendamentos")
    public ModelAndView agendamentoConsulta() {
        return new ModelAndView("agendamento-consulta");
    }    

    @GetMapping("cadastro/consultas")
    public ModelAndView cadastroConsulta(){
        return new ModelAndView("cad-consulta");
    }
    
    @GetMapping("admin")
    public ModelAndView adminIndex(){
        return new ModelAndView("admin");
    }

    @GetMapping("historico")
    public ModelAndView historicoConsultas(){
        return new ModelAndView("historico-consultas");
    }
    

    @GetMapping("paciente/consultas")
    public ModelAndView pacienteIndex(){
        return new ModelAndView("paciente-consultas");
    }

    @GetMapping("paciente")
    public ModelAndView pacientePerfil(){
        return new ModelAndView("paciente-perfil");
    }

    @GetMapping("medico/consultas")
    public ModelAndView medicoConsultas(){
        return new ModelAndView("medico-consultas");
    }

}