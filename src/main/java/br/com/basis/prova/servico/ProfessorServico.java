package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTOSalvar;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.mapper.ProfessorDetalhadoMapper;
import br.com.basis.prova.servico.mapper.ProfessorMapper;
import br.com.basis.prova.servico.mapper.ProfessorMapperSalvar;
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
    private ProfessorMapperSalvar professorMapperSalvar;

    public ProfessorServico(ProfessorMapper professorMapper, ProfessorDetalhadoMapper professorDetalhadoMapper,
                            ProfessorMapperSalvar professorMapperSalvar, ProfessorRepositorio professorRepositorio) {
        this.professorMapper = professorMapper;
        this.professorRepositorio = professorRepositorio;
        this.professorDetalhadoMapper = professorDetalhadoMapper;
        this.professorMapperSalvar = professorMapperSalvar;
    }

    public ProfessorDetalhadoDTO salvar(ProfessorDTOSalvar professorDTOSalvar) {
        Professor professor = professorMapperSalvar.toEntity(professorDTOSalvar);
        this.professorRepositorio.save(professor);
        return professorDetalhadoMapper.toDto(professor);
    }

    public void excluir(Integer id) {
        this.professorRepositorio.deleteById(id);
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
        for (ProfessorDetalhadoDTO professorDetalhadoDTO: professoresDetalhadoDTO) {
            List<String> list = new ArrayList<String>();
            List<DisciplinaDTO> disciplinasDTO = professorDetalhadoDTO.getDisciplinas();
            for (DisciplinaDTO disciplinaDTO : disciplinasDTO) {
                if(disciplinaDTO.getAtiva()==1) {// 1 igual a ativo true.
                    list.add(disciplinaDTO.getNome());
                }
                professorDetalhadoDTO.setNomeDisciplina(list);
            }
        }
        return professoresDetalhadoDTO;
    }

}
