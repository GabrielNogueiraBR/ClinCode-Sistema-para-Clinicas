package com.api.clincode.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.api.clincode.entity.AgendamentoEntity;
import com.api.clincode.entity.PacienteEntity;
import com.api.clincode.service.AgendamentoService;
import com.api.clincode.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteService service;

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping()
    public List<PacienteEntity> getAllPacientes() {
        return service.getAllPacientes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PacienteEntity> getPacienteByID(@PathVariable final int id) {
        PacienteEntity paciente;
        paciente = service.getPacienteByID(id);

        if(paciente != null)
            return ResponseEntity.ok(paciente);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Void> postPaciente(@ModelAttribute PacienteEntity entity) {
        entity = service.salvarPaciente(entity);

        if(entity != null)
        {
            URI uri = URI.create("http://localhost:8080/pacientes/"+entity.getIdPessoa());
            return ResponseEntity.created(uri).build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEntity> putPacienteByID(@PathVariable int id, @RequestBody PacienteEntity paciente) {
       
        paciente = service.putPacienteByID(id, paciente);

        if(paciente != null){
            return ResponseEntity.ok(paciente);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacienteByID(@PathVariable int id) {
        Boolean val = service.existePacienteByID(id);

        if(val == true){
            service.deletePacienteByID(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Pagina de perfil de cada paciente
    @GetMapping("{id}/perfil")
    public ModelAndView pacientePerfil(@PathVariable final int id) {
        ModelAndView mv = new ModelAndView("paciente-perfil");

        mv.addObject("paciente", service.getPacienteByID(id));

        return mv;
    }

    //Exibir as CONSULTAS FUTURAS do paciente
    @GetMapping("{id}/consultas/agendadas")
    public ModelAndView pacienteConsultasAgendadas() {

        //Buscar o paciente referente ao id

        //Buscar as consultas AGENDADAS do paciente (List<>)

        //Adicionar essa lista de consultas (caso tenha) ao ModelAndView para ser exibido dinamicamente

        //Exibir a tela com as consultas agendadas
        return new ModelAndView("paciente-consultas-agendadas");
    }

    //Exibir as consultas JA REALIZADAS do paciente
    @GetMapping("{id}/consultas/historico")
    public ModelAndView historicoConsultasHistorico() {
        
        //Buscar o paciente referente ao id

        //Buscar as consultas do paciente (List<>)

        //Adicionar essa lista de consultas (caso tenha) ao ModelAndView para ser exibido dinamicamente

        //Exibir a tela com as CONSULTAS REALIZADAS
        return new ModelAndView("paciente-consultas-historico");
    }


    /**
     * Esse metodo vai fazer o cadastramento de Agendamento de Consultas com base no {@code id} do paciente passado via a URL de cadastro. Dessa forma podemos relacionar um agendamento com o Paciente que abriu aquele agendamento.
     * @param id do paciente que esta realizando o agendamento.
     * @param entity objeto AgendamentoEntity que sera preenchido junto com o form.
     * @param request
     * @param builder
     * @return
     */
    @PostMapping("/{id}/cadastro/agendamentos")
    public ResponseEntity<Void> cadastraAgendamentoConsulta(@PathVariable int id, @ModelAttribute AgendamentoEntity entity, HttpServletRequest request, UriComponentsBuilder builder) {  

        entity = agendamentoService.cadastraConsulta(id, entity);

        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + entity.getIdAgendamento()).build();
        
        URI uri = uriComponents.toUri();

        return ResponseEntity.created(uri).build();
    }
}
