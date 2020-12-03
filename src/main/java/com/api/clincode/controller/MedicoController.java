package com.api.clincode.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.api.clincode.entity.ConsultaEntity;
import com.api.clincode.entity.MedicoEntity;
import com.api.clincode.service.AgendamentoService;
import com.api.clincode.service.ConsultaService;
import com.api.clincode.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping()
    public List<MedicoEntity> getAllMedicos(){
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoEntity> getMedicoByID(@PathVariable final int id){
        MedicoEntity medico = medicoService.getMedicoByID(id);

        if(medico != null){
            return ResponseEntity.ok(medico);
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Void> cadastraMedico(@ModelAttribute MedicoEntity medico, HttpServletRequest request, UriComponentsBuilder builder){
        medico = medicoService.cadastraMedico(medico);

        if(medico != null){
            UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + medico.getIdPessoa()).build();
            return ResponseEntity.created(uriComponents.toUri()).build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoEntity> putMedicoByID(@PathVariable final int id, @RequestBody MedicoEntity medico){
        medico = medicoService.putMedicoByID(id,medico);

        if(medico != null){
            return ResponseEntity.ok(medico);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaMedicoByID(@PathVariable final int id){
        
        Boolean existe = medicoService.existeMedicoByID(id);

        if(existe == true)
        {
            medicoService.deletaMedicoByID(id);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    //Pagina de perfil de cada medico
    @GetMapping("{id}/perfil")
    public ModelAndView medicoPerfil(@PathVariable final int id){
        
        //Buscar o medico correspondente do id

        //Adicionar esse objeto no ModelAndView

        //Exibir a tela de perfil
        
        ModelAndView mv = new ModelAndView("medico-perfil");
        mv.addObject("medico", medicoService.getMedicoByID(id));
        return mv;
        
        // return new ModelAndView("medico-perfil");
    }

    //Mostra todas as consultas que foram agendadas
    @GetMapping("/{id}/consultas/agendadas")
    public ModelAndView medicoConsultas(){
        
        //pegar a lista de consultas agendadas
        ModelAndView consultasAgendadas = new ModelAndView("consultas-agendadas");

        consultasAgendadas.addObject("agendamentos", agendamentoService.getAllAgendamentos());
        
        return consultasAgendadas;
    }

    @GetMapping("/{id}/consultas/agendadas/{idAgendamento}/consultar")
    public ModelAndView consultarPaciente(@PathVariable int id, @PathVariable int idAgendamento){
        //verifica se existe o medico
        medicoService.getMedicoByID(id);

        //verifica se existe o agendamento
        agendamentoService.getAgendamentoByID(idAgendamento);
        return new ModelAndView("cad-consulta");
    }

    @PostMapping("/{idMedico}/consultas/agendadas/{idAgendamento}/consultar")
    public ResponseEntity<Void> cadastraConsulta(@ModelAttribute ConsultaEntity entity, @PathVariable int idMedico, @PathVariable int idAgendamento, HttpServletRequest request, UriComponentsBuilder builder) {
        
        entity = consultaService.cadastraConsulta(entity, idMedico, idAgendamento);

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + entity.getIdConsulta()).build();

        URI uri = uriComponents.toUri();

        return ResponseEntity.created(uri).build();
    }

    
    @GetMapping("/{idMedico}/consultas/historico")
    public ModelAndView historicoConsultas(@PathVariable int idMedico){
        //Buscar o medico referente ao id
        MedicoEntity medicoEntity = medicoService.getMedicoByID(idMedico);

        //Buscar as consultas do medico (List<>)
        List<ConsultaEntity> consultas = consultaService.getConsultaByMedico(medicoEntity);

        //Adicionar essa lista de consultas (caso tenha) ao ModelAndView para ser exibido dinamicamente
        ModelAndView mv = new ModelAndView("paciente-consultas-historico");
        mv.addObject("consulta", consultas);

        //Exibir a tela com as CONSULTAS REALIZADAS
        return mv;
    }
}
