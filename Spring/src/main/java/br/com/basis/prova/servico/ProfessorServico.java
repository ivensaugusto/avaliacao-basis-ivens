package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.*;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.ProfessorDetalhadoMapper;
import br.com.basis.prova.servico.mapper.ProfessorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfessorServico {

    private ProfessorRepositorio professorRepositorio;
    private ProfessorMapper professorMapper;
    private ProfessorDetalhadoMapper professorDetalhadoMapper;
    private DisciplinaRepositorio disciplinaRepositorio;

    public ProfessorServico(ProfessorMapper professorMapper, ProfessorDetalhadoMapper professorDetalhadoMapper,
                            ProfessorRepositorio professorRepositorio, DisciplinaRepositorio disciplinaRepositorio) {

        this.professorMapper = professorMapper;
        this.professorRepositorio = professorRepositorio;
        this.professorDetalhadoMapper = professorDetalhadoMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    public ProfessorDTO consultarPorId(Integer id) {
        ProfessorDTO professorDTO = professorMapper.toDto(professorRepositorio.findById(id).get());
        professorDTO.setIdade(LocalDate.now().getYear() - professorDTO.getDataNascimento().getYear());
        return professorDTO;
    }

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);

        if (verificarNome(professor)) {
            throw new RegraNegocioException("Professor já existe");
        }

        if (verificarMatricula(professor)) {
            throw new RegraNegocioException("Matrícula já existe");
        }
        professorRepositorio.save(professor);

        return professorMapper.toDto(professor);
    }

    private boolean verificarNome(Professor professor) {
        Professor professorNome = professorRepositorio.findByNome(professor.getNome());
        return !(professorNome == null || professorNome.getId().equals(professor.getId()));
    }

    private boolean verificarMatricula(Professor professor) {
        Professor professorMatricula = professorRepositorio.findByMatricula(professor.getMatricula());
        return !(professorMatricula == null || professorMatricula.getId().equals(professor.getId()));
    }

    public List<ProfessorDTO> consultar() {
        List<ProfessorDTO> professores = professorMapper.toDto(this.professorRepositorio.findAll());
        preencherIdades(professores);
        return professores;
    }

    private void preencherIdades(List<ProfessorDTO> professor) {
        professor.forEach(professorDTO -> {
            professorDTO.setIdade(LocalDate.now().getYear() - professorDTO.getDataNascimento().getYear());
        });
    }

    public List<ProfessorDetalhadoDTO> detalhar() {
        List<Professor> vv =this.professorRepositorio.findAll();
        List<ProfessorDetalhadoDTO> professores = professorDetalhadoMapper.toDto(vv);

        professores.forEach(professorDetalhadoDTO -> {
            List<String> listNomeDisciplinasDTO = new ArrayList<String>();
//            List<DisciplinaDTO> disciplinasDTO = professorDetalhadoDTO.getDisciplinas();
//            for (DisciplinaDTO disciplinaDTO : disciplinasDTO) {
//                if (disciplinaDTO.getAtiva() == 1) {
//                    listNomeDisciplinasDTO.add(disciplinaDTO.getNome());
//                }
//            }
            professorDetalhadoDTO.setNomeDisciplinas(listNomeDisciplinasDTO);
        });
        return professores;
    }

    public void excluir(Integer id) {

        Professor professor = professorRepositorio.findById(id).orElseThrow(() ->
                new RegraNegocioException("Professor não encontrado"));

        List<Disciplina> disciplinas = disciplinaRepositorio.findAllByAtivaAndProfessor(1, professor.getId());

        if (!disciplinas.isEmpty()) {
            throw new RegraNegocioException("professor responsável por disciplinas");
        }
        professorRepositorio.delete(professor);
    }

    public void excluirPorMatricula(String matricula) {
        Professor professor = professorRepositorio.findByMatricula(matricula);
        if (professor == null) {
            throw new RegraNegocioException("Professor não existe");
        }
        excluir(professor.getId());
    }
}

