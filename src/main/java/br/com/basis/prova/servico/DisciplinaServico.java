package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTOSalvar;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaRepositorio disciplinaRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    public DisciplinaDTO salvar(DisciplinaDTOSalvar disciplinaDTOSalvar) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTOSalvar);
        this.disciplinaRepositorio.save(disciplina);
        // this.professorRepositorio.saveAll(disciplina.getProfessor());
        return disciplinaMapper.toDto(disciplina);
    }

    public void excluir(Integer id) {
        this.disciplinaRepositorio.deleteById(id);
    }

    public List<DisciplinaDTO> consultar() {
        List<DisciplinaDTO> disciplinas = disciplinaMapper.toDto(this.disciplinaRepositorio.findAll());
        return disciplinas;
    }

    public List<DisciplinaDTO> detalhar() {
        List<DisciplinaDTO> disciplinas = disciplinaMapper.toDto(this.disciplinaRepositorio.findAll());
        return disciplinas;
    }

}
