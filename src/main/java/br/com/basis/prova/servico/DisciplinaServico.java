package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);
        return disciplinaMapper.toDto(disciplina);
    }

    public void excluir(Integer id) {
    }

    public List<DisciplinaDTO> consultar() {
        return new ArrayList<>();
    }

    public List<DisciplinaDetalhadaDTO> detalhar() {
        return new ArrayList<>();
    }

}
