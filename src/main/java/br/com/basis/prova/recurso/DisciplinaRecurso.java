package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.servico.DisciplinaServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaRecurso {

    private static final String API_DISCIPLINAS = "/disciplinas";

    private final DisciplinaServico disciplinaServico;

    public DisciplinaRecurso(DisciplinaServico disciplinaServico) {
        this.disciplinaServico = disciplinaServico;
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> salvar(@RequestBody DisciplinaGravarDTO disciplinaSalvar) throws URISyntaxException {
        DisciplinaDTO result = disciplinaServico.salvar(disciplinaSalvar);
        return ResponseEntity.created(new URI(API_DISCIPLINAS + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<DisciplinaDTO> editar(@RequestBody DisciplinaGravarDTO disciplinaSalvar) throws URISyntaxException {
        DisciplinaDTO result = disciplinaServico.editar(disciplinaSalvar);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        disciplinaServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/deletePorNome/{nome}")
    public ResponseEntity<Void> excluirPorNome(@PathVariable("nome") String nome) {
        disciplinaServico.excluirPorNome(nome);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> consultar() {
        return ResponseEntity.ok(disciplinaServico.consultar());
    }

    @GetMapping("/detalhes")
    public ResponseEntity<List<DisciplinaDetalhadaDTO>> detalhar() {
        return ResponseEntity.ok(disciplinaServico.detalhar());
    }

}
