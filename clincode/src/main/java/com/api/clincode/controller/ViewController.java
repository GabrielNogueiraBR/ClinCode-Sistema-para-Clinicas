package com.api.clincode.controller;

import com.api.clincode.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {
    
    @Autowired
    private PacienteService pacienteService;

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
    
    @GetMapping("/pacientes/{id}/cadastro/agendamentos")
    public ModelAndView agendamentoConsulta(@PathVariable int id) {
        //valida se o paciente existe, caso contrario retorna o erro 404
        pacienteService.getPacienteByID(id);
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

    
}