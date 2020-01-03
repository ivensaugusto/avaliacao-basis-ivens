package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadoMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaDetalhadoMapper disciplinaDetalhadoMapper;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaRepositorio disciplinaRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    public Disciplina salvar(Disciplina disciplina) {
        return this.disciplinaRepositorio.save(disciplina);
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
