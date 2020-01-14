package br.com.basis.prova.recurso;


import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.servico.ProfessorServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
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

    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<Void> excluirPorMatricula(@PathVariable("matricula") String matricula) {
        professorServico.excluirPorMatricula(matricula);
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
