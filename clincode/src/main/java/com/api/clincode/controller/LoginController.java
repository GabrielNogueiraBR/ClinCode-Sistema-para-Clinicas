package com.api.clincode.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import com.api.clincode.model.Login;
import com.api.clincode.service.AtendenteService;
import com.api.clincode.service.MedicoService;
import com.api.clincode.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private AtendenteService atendenteService;

    @GetMapping()
    public ModelAndView paginaLogin() {
        return new ModelAndView("login");
    }

    @PostMapping()
    public RedirectView entrar(@ModelAttribute Login login, HttpServletRequest request, UriComponentsBuilder builder){
        
        RedirectView redirectView = new RedirectView();
        
        String uriLogin = "";

        //Paciente
        if(login.getCargo().equals("pacientes")){
            uriLogin = pacienteService.entrar(login);
        }
        //Atendente
        else if(login.getCargo().equals("atendentes")){
            uriLogin = atendenteService.entrar(login);
        }
        //Medico
        else if(login.getCargo().equals("medicos")){
            uriLogin = medicoService.entrar(login);
        }
        //Administrador
        else if(login.getCargo().equals("administadores")){
            uriLogin = "admin";
        }
        else{
            uriLogin = "/cargo/" + login.getCargo() + "/email/" + login.getEmail();
        }
        
        UriComponents uriComponents = builder.path(uriLogin).build();
        URI uri = uriComponents.toUri();

        redirectView.setUrl(uri.toString());
        return redirectView;
    }

}
