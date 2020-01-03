package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.mapper.ProfessorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfessorServico {

    private ProfessorRepositorio professorRepositorio;
    private ProfessorMapper professorMapper;

    public ProfessorServico(ProfessorMapper professorMapper, ProfessorRepositorio professorRepositorio) {
        this.professorMapper = professorMapper;
        this.professorRepositorio = professorRepositorio;
    }

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);
        this.professorRepositorio.save(professor);
        // this.disciplinaRepositorio.saveAll(professor.getDisciplinas());
        return professorMapper.toDto(professor);
    }

    public void excluir(Integer id) {
        this.professorRepositorio.deleteById(id);
    }

    public List<ProfessorDTO> consultar() {
        return professorMapper.toDto(this.professorRepositorio.findAll());
    }

    public List<ProfessorDetalhadoDTO> detalhar() {
        return professorMapper.toDetalhadoDto(this.professorRepositorio.findAll());
    }

}
