package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.servico.AlunoServico;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoRecurso {

    private static final String API_ALUNOS = "/alunos";

    private final AlunoServico alunoServico;
    private  AlunoMapper alunoMapper;

    public AlunoRecurso(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @PostMapping("/salvar")
    public ResponseEntity<AlunoDTO> salvar(@RequestBody AlunoDTOSalvar alunoDTOSalvar) throws URISyntaxException {
        AlunoDTO result = alunoMapper.toDto(alunoServico.salvar(alunoDTOSalvar));
        return ResponseEntity.created(new URI(API_ALUNOS + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<AlunoDTO> editar(@RequestBody AlunoDTOSalvar alunoDTOSalvar) throws URISyntaxException {
        AlunoDTO result = alunoMapper.toDto(alunoServico.salvar(alunoDTOSalvar));
        return ResponseEntity.created(new URI(API_ALUNOS + result.getId())).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        alunoServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> consultar() {
        return ResponseEntity.ok(alunoServico.consultar());
    }

    @GetMapping("/detalhes")
    public ResponseEntity<List<AlunoDetalhadoDTO>> detalhar() {
        return ResponseEntity.ok(alunoServico.detalhar());
    }

}
