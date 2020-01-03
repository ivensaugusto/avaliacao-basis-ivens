package br.com.basis.prova.recurso;


import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.servico.ProfessorServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorRecurso {

    private static final String API_PROFESSORES = "/professores";

    private final ProfessorServico professorServico;

    public ProfessorRecurso(ProfessorServico professorServico) {
        this.professorServico = professorServico;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ProfessorDTO> salvar(@RequestBody ProfessorDTO professorDTO) throws URISyntaxException {
        ProfessorDTO result = professorServico.salvar(professorDTO);
        return ResponseEntity.created(new URI(API_PROFESSORES + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<ProfessorDTO> editar(@RequestBody ProfessorDTO professorDTO) throws URISyntaxException {
        ProfessorDTO result = professorServico.salvar(professorDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        professorServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> consultar() {
        return ResponseEntity.ok(professorServico.consultar());
    }

    @GetMapping("/detalhes")
    public ResponseEntity<List<ProfessorDetalhadoDTO>> detalhar() {
        return ResponseEntity.ok(professorServico.detalhar());
    }

}
