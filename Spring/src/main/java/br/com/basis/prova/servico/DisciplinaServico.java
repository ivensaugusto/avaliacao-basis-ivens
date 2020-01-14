package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaDetalhadaMapper disciplinaDetalhadaMapper;
    private AlunoRepositorio alunoRepositorio;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaDetalhadaMapper disciplinaDetalhadaMapper,
                             DisciplinaRepositorio disciplinaRepositorio, AlunoRepositorio alunoRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaDetalhadaMapper = disciplinaDetalhadaMapper;
        this.alunoRepositorio = alunoRepositorio;
    }

    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaDTO.getNome());
        if (disciplina == null) {
            disciplina = disciplinaMapper.toEntity(disciplinaDTO);
            this.disciplinaRepositorio.save(disciplina);
        }
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
        List<DisciplinaDetalhadaDTO> disciplinas = disciplinaDetalhadaMapper.toDto( this.disciplinaRepositorio.findAll());
        return disciplinas;
    }
/*

    public DisciplinaDTO editar(DisciplinaDTO disciplinaGravarDTO) {
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaGravarDTO.getNome());
        disciplinaGravarDTO.setId(disciplina.getId());
        disciplina = disciplinaMapper.toEntity(disciplinaGravarDTO);
        this.disciplinaRepositorio.save(disciplina);
        return disciplinaMapper.toDto(disciplina);
    }
*/

}
