package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorGravarDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.mapper.ProfessorDetalhadoMapper;
import br.com.basis.prova.servico.mapper.ProfessorGravarMapper;
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
    private ProfessorGravarMapper professorGravarMapper;

    public ProfessorServico(ProfessorMapper professorMapper, ProfessorDetalhadoMapper professorDetalhadoMapper,
                            ProfessorGravarMapper professorGravarMapper, ProfessorRepositorio professorRepositorio) {
        this.professorMapper = professorMapper;
        this.professorRepositorio = professorRepositorio;
        this.professorDetalhadoMapper = professorDetalhadoMapper;
        this.professorGravarMapper = professorGravarMapper;
    }

    public ProfessorDetalhadoDTO salvar(ProfessorGravarDTO professorGravarDTO) {
        Professor professor = professorGravarMapper.toEntity(professorGravarDTO);
        this.professorRepositorio.save(professor);
        return professorDetalhadoMapper.toDto(professor);
    }

    public void excluir(Integer id) {
        try {
            this.professorRepositorio.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO mensagem de erro de professor com disciplina.
        }
    }

    public void excluirPorMatricula(String matricula) { //TODO mensagem de erro de professor com disciplina.
        this.professorRepositorio.deleteByMatricula(matricula);
    }

    public List<ProfessorDTO> consultar() {
        List<ProfessorDTO> professores = professorMapper.toDto(this.professorRepositorio.findAll());
        for (ProfessorDTO professor : professores) {
            professor.setIdade(LocalDate.now().getYear() - professor.getDataNascimento().getYear());
        }
        return professores;
    }

    public List<ProfessorDetalhadoDTO> detalhar() {
        List<ProfessorDetalhadoDTO> professoresDetalhadoDTO = professorDetalhadoMapper.toDto(this.professorRepositorio.findAll());
        for (ProfessorDetalhadoDTO professorDetalhadoDTO : professoresDetalhadoDTO) {
            List<String> list = new ArrayList<String>();
            List<DisciplinaDTO> disciplinasDTO = professorDetalhadoDTO.getDisciplinas();
            for (DisciplinaDTO disciplinaDTO : disciplinasDTO) {
                if (disciplinaDTO.getAtiva() == 1) {// 1 igual a ativo true.
                    list.add(disciplinaDTO.getNome());
                }
                professorDetalhadoDTO.setNomeDisciplina(list);
            }
        }
        return professoresDetalhadoDTO;
    }

    public ProfessorDTO editar(ProfessorGravarDTO professorGravarDTO) {
        Professor professor = this.professorRepositorio.findByMatricula(professorGravarDTO.getMatricula());
        professorGravarDTO.setId(professor.getId());
        professor = professorGravarMapper.toEntity(professorGravarDTO);
        this.professorRepositorio.save(professor);
        return professorMapper.toDto(professor);
    }
}

