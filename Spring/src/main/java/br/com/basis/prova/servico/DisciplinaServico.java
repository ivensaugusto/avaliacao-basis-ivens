package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.*;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaSemAlunoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaSemAlunoMapper disciplinaSemAlunoMapper;
    private DisciplinaDetalhadaMapper disciplinaDetalhadaMapper;
    private AlunoRepositorio alunoRepositorio;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaDetalhadaMapper disciplinaDetalhadaMapper,
                             DisciplinaSemAlunoMapper disciplinaSemAlunoMapper, DisciplinaRepositorio disciplinaRepositorio,
                             AlunoRepositorio alunoRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaDetalhadaMapper = disciplinaDetalhadaMapper;
        this.alunoRepositorio = alunoRepositorio;
        this.disciplinaSemAlunoMapper = disciplinaSemAlunoMapper;
    }

    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);

        this.disciplinaRepositorio.save(disciplina);
        return disciplinaMapper.toDto(disciplina);
    }

    public void excluir(Integer id) {

        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(() ->
                new RegraNegocioException("disciplina não encontrada"));

        if (!disciplina.getAlunos().isEmpty()) {
            throw new RegraNegocioException("Disciplina com alunos matriculados");
        }
        disciplinaRepositorio.delete(disciplina);
    }

    public List<DisciplinaDTO> consultar() {
        List<DisciplinaDTO> disciplinas = disciplinaMapper.toDto(this.disciplinaRepositorio.findAll());
        return disciplinas;
    }

    public List<DisciplinaDetalhadaDTO> detalhar() {
        List<Disciplina> disciplinas = this.disciplinaRepositorio.findAll();
        return disciplinaDetalhadaMapper.toDto(disciplinas);
    }

    public DisciplinaDTO consultarPorId(Integer id) {
        DisciplinaDTO disciplinaDTO = disciplinaMapper.toDto(disciplinaRepositorio.findById(id).get());
        return disciplinaDTO;
    }

}
